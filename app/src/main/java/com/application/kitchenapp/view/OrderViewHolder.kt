package com.application.kitchenapp.view

import android.view.ViewGroup
import com.application.kitchenapp.R
import com.application.kitchenapp.model.SectionDetailModel
import com.application.kitchenapp.view.base.BaseRecyclerViewHolder
import kotlinx.android.synthetic.main.view_order.view.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionViewHolder, v 0.1 05/04/21 16.50 by Richo Mahardika
 */
class OrderViewHolder(parent: ViewGroup) :
    BaseRecyclerViewHolder<SectionDetailModel>(parent, R.layout.view_order_holder) {
    override fun bindData(data: SectionDetailModel?) {
        data?.run {
            itemView.tv_order_time.text = orderTime
            itemView.tv_order_number.text = orderNumber
            itemView.tv_order_menu.text = orderMenu
            itemView.tv_order_status.text = "DONE"
        }
    }
}