package com.application.kitchenapp.processor

import android.content.Context
import com.application.kitchenapp.model.SectionDetailModel
import kotlinx.coroutines.delay


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderProcessor, v 0.1 29/03/21 12.55 by Richo Mahardika
 */
class OrderProcessor(context: Context) : AbstractOrderProcessor(context) {

    override fun dispatchToCourier(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    ) {
        onResult(result.apply { orderStatus = "DEPART" })
    }

    override fun processToShelf(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    ) {
        onResult(result.apply { orderStatus = "TO_COURIER" })
    }

    override suspend fun processInKitchen(
        result: SectionDetailModel,
        onResult: (result: SectionDetailModel) -> Unit
    ) {
        delay((1000..6000).random().toLong())
        onResult(result.apply { orderStatus = "TO_SHELF" })
    }

    override fun canProcessOrder(int: Int) = false
}