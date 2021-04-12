package com.application.kitchenapp.view.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionCardViewHolder, v 0.1 05/04/21 16.28 by Richo Mahardika
 */
abstract class BaseRecyclerViewHolder<T>(
    parent: ViewGroup,
    layoutId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    open fun bindData(data: T?) {
        // default implementation
    }
}