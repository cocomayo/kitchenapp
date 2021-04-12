package com.application.kitchenapp.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kitchenapp.model.SectionDetailModel
import com.application.kitchenapp.view.OrderViewHolder
import com.application.kitchenapp.view.base.BaseRecyclerViewHolder


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderRecyclerViewAdapter, v 0.1 12/04/21 15.24 by Richo Mahardika
 */
class OrderRecyclerViewAdapter :
    RecyclerView.Adapter<BaseRecyclerViewHolder<SectionDetailModel>>() {

    private var dataSet: MutableList<SectionDetailModel>? = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseRecyclerViewHolder<SectionDetailModel> {
        return OrderViewHolder(parent)
    }

    override fun onBindViewHolder(
        holder: BaseRecyclerViewHolder<SectionDetailModel>,
        position: Int
    ) {
        holder.bindData(dataSet?.get(position))
    }

    override fun getItemCount() = dataSet?.size ?: 0

    fun setItems(model: SectionDetailModel) {
        dataSet?.add(model)
        notifyItemChanged(dataSet?.size ?: 0)
    }
}