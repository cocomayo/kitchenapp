package com.application.kitchenapp.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kitchenapp.model.SectionDetailModel
import com.application.kitchenapp.model.SectionModel
import com.application.kitchenapp.view.SectionViewHolder
import com.application.kitchenapp.view.base.BaseRecyclerViewHolder


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version BaseSectionViewAdapter, v 0.1 05/04/21 16.05 by Richo Mahardika
 */
class DashboardRecyclerViewAdapter :
    RecyclerView.Adapter<BaseRecyclerViewHolder<SectionModel>>() {

    private var dataSet: MutableList<SectionModel>? = mutableListOf()
    private var orderSet: MutableList<SectionDetailModel>? = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = SectionViewHolder(parent)

    override fun getItemCount() = dataSet?.size ?: 0

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<SectionModel>, position: Int) {
        holder.bindData(dataSet?.get(position))
    }

    fun setItems(model: SectionModel) {
        dataSet?.add(model)
        notifyItemChanged(dataSet?.size ?: 0)
    }
}