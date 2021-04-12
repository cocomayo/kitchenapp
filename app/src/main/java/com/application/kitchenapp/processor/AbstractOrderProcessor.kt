package com.application.kitchenapp.processor

import android.content.Context
import com.application.kitchenapp.model.SectionDetailModel
import kotlinx.coroutines.*
import java.util.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderProcessor, v 0.1 29/03/21 12.48 by Richo Mahardika
 */
abstract class AbstractOrderProcessor(context: Context) {
    private val date by lazy { Date() }

    private val orders by lazy {
        context.getOrdersFromFile()
    }

    fun processOrder(onResult: (result: SectionDetailModel) -> Unit): Job {
        var counter = 0
        return CoroutineScope(Dispatchers.Main).launch {
            for (order in orders) {
                processInKitchen(
                    SectionDetailModel(date.toTimeString(), order.id, order.name, "IN_KITCHEN")
                ) { kitchen ->
                    if (kitchen.orderStatus == "TO_SHELF") processToShelf(kitchen) { shelf ->
                        if (shelf.orderStatus == "TO_COURIER") dispatchToCourier(shelf) { courier ->
                            onResult(courier)
                        }
                    }
                }

                if (counter == DEFAULT_ORDER_INTERVAL) {
                    delay(TIME_INTERVAL.toLong())
                    counter = 0
                }

                counter++
            }

            this.cancel()
        }
    }

    protected abstract fun dispatchToCourier(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    )

    protected abstract fun processToShelf(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    )

    protected abstract suspend fun processInKitchen(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    )

    protected abstract fun canProcessOrder(int: Int): Boolean

    companion object {
        const val DEFAULT_ORDER_INTERVAL = 2
        const val TIME_INTERVAL = 2000
    }
}
