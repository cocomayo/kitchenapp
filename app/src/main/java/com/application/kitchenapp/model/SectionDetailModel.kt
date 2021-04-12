package com.application.kitchenapp.model


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionDetailModel, v 0.1 05/04/21 16.37 by Richo Mahardika
 */
data class SectionDetailModel(
    val orderTime: String,
    val orderNumber: String = "0",
    val orderMenu: String,
    var orderStatus: String
)