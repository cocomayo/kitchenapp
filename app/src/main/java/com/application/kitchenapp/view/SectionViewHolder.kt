package com.application.kitchenapp.view

import android.view.ViewGroup
import com.application.kitchenapp.R
import com.application.kitchenapp.model.SectionModel
import com.application.kitchenapp.view.base.BaseRecyclerViewHolder
import kotlinx.android.synthetic.main.view_section_cardview.view.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionViewHolder, v 0.1 05/04/21 16.50 by Richo Mahardika
 */
class SectionViewHolder(parent: ViewGroup) :
    BaseRecyclerViewHolder<SectionModel>(parent, R.layout.view_section_holder) {

    private var title = "Overall"
        set(state) {
            field = state
            when (state) {
                OVERALL_TITLE -> itemView.ll_section_wrapper.setBackgroundColor(
                    itemView.resources.getColor(R.color.tosca)
                )
                KITCHEN_TITLE -> itemView.ll_section_wrapper.setBackgroundColor(
                    itemView.resources.getColor(R.color.purple_500)
                )
                SHELVES_TITLE -> itemView.ll_section_wrapper.setBackgroundColor(
                    itemView.resources.getColor(R.color.orange)
                )
                else -> itemView.ll_section_wrapper.setBackgroundColor(
                    itemView.resources.getColor(R.color.blue_50)
                )
            }
        }

    override fun bindData(data: SectionModel?) {
        data?.run {
            this@SectionViewHolder.title = title
            itemView.tv_section_title.text = title
            itemView.et_report.setText(report)
        }
    }

    companion object {
        const val OVERALL_VIEW_TYPE = 0
        const val KITCHEN_VIEW_TYPE = 1
        const val SHELVES_VIEW_TYPE = 2
        const val COURIER_VIEW_TYPE = 3

        const val OVERALL_TITLE = "Overall"
        const val KITCHEN_TITLE = "Kitchen"
        const val SHELVES_TITLE = "Shelves"
        const val COURIER_TITLE = "Courier"
    }
}