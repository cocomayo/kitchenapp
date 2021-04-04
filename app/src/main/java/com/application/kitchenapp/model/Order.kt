package com.application.kitchenapp.model

import java.io.IOException
import java.io.InputStream


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version Order, v 0.1 29/03/21 12.00 by Richo Mahardika
 */
data class Order(
    val id: String,
    val name: String,
    val temp: String,
    val shelfLife: Int,
    val decayRate: Float
)