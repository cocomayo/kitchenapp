package com.application.kitchenapp.processor

import android.content.Context
import kotlinx.coroutines.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderProcessor, v 0.1 29/03/21 12.48 by Richo Mahardika
 */
abstract class AbstractOrderProcessor(context: Context) {
    private var orders = context.getOrdersFromFile()

    fun processOrder(onResult: (result: String) -> Unit): Job {
        var counter = 0
        return CoroutineScope(Dispatchers.Main).launch {
            for (order in orders) {
                this@AbstractOrderProcessor.dispatchOrderToKitchen { successKitchen ->
                    if (successKitchen) dispatchToShelf { successShelf ->
                        if (successShelf) dispatchToCourier {
                            onResult(order.name)
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

    protected abstract fun dispatchToCourier(onResult: (result: Boolean) -> Unit)

    protected abstract fun dispatchToShelf(onResult: (result: Boolean) -> Unit)

    protected abstract fun dispatchOrderToKitchen(onResult: (result: Boolean) -> Unit)

    protected abstract fun canProcessOrder(int: Int): Boolean

    companion object {
        const val DEFAULT_ORDER_INTERVAL = 2
        const val TIME_INTERVAL = 2000
    }
}
