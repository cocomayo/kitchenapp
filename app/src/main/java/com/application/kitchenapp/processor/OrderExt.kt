package com.application.kitchenapp.processor

import android.content.Context
import com.application.kitchenapp.model.Order
import com.google.gson.Gson
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import kotlin.math.roundToInt


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version ShelfLifeExt, v 0.1 29/03/21 13.10 by Richo Mahardika
 */

fun Order.valueFormula(isFull: Boolean): Int {
    val shelfDecayModifier = if (isFull) 2 else 1
    val orderAge = 1 // assume orderAge = 1

    return (((shelfLife.minus(orderAge) - decayRate) * orderAge * shelfDecayModifier) / shelfLife).roundToInt()
}

fun Context.getOrdersFromFile(): List<Order> {
    val orderJson = inputStreamToString(this.assets.open("json/data/orders.json"))
    return Gson().fromJson(orderJson, List::class.java).map {
        Gson().fromJson(it.toString(), Order::class.java)
    }
}

fun inputStreamToString(inputStream: InputStream): String {
    return try {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        String(bytes)
    } catch (e: IOException) {
        ""
    }
}