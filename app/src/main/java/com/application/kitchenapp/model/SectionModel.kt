package com.application.kitchenapp.model


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionModel, v 0.1 05/04/21 16.34 by Richo Mahardika
 */
data class SectionModel(
    val title: String,
    val status: String,
    val items: List<SectionDetailModel>? = emptyList(),
    val report: String? = ""
)