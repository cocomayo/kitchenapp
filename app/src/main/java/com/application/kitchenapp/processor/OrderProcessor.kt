package com.application.kitchenapp.processor

import android.content.Context


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderProcessor, v 0.1 29/03/21 12.55 by Richo Mahardika
 */
class OrderProcessor(context: Context) : AbstractOrderProcessor(context) {

    override fun canProcessOrder(int: Int) = false

    override fun dispatchToCourier(onResult: (result: Boolean) -> Unit) {
        onResult(true)
    }

    override fun dispatchToShelf(onResult: (result: Boolean) -> Unit) {
        onResult(true)
    }

    override fun dispatchOrderToKitchen(onResult: (result: Boolean) -> Unit) {
        onResult(true)
    }
}