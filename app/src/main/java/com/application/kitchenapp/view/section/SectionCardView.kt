package com.application.kitchenapp.view.section

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.kitchenapp.R
import com.application.kitchenapp.processor.OrderProcessor
import com.application.kitchenapp.view.adapter.OrderRecyclerViewAdapter
import com.application.kitchenapp.view.base.BaseRichView
import kotlinx.android.synthetic.main.view_section_cardview.view.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version SectionCardView, v 0.1 31/03/21 13.21 by Richo Mahardika
 */
class SectionCardView : BaseRichView {

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
            super(context, attrs, defStyleAttr)

    @Suppress("unused")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    override fun getLayout(): Int = R.layout.view_section_cardview

    override fun setup() {
        OrderRecyclerViewAdapter().apply {
            rv_order_detail?.adapter = this
            rv_order_detail?.layoutManager = LinearLayoutManager(context)

            OrderProcessor(context).processOrder {
                setItems(it)
            }
        }
    }
}