package com.application.kitchenapp.view.section

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import com.application.kitchenapp.R
import com.application.kitchenapp.view.base.BaseRichView


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version OrderView, v 0.1 12/04/21 15.02 by Richo Mahardika
 */
class OrderView : BaseRichView {
    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
            super(context, attrs, defStyleAttr)

    @Suppress("unused")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    override fun getLayout(): Int = R.layout.view_order

    override fun setup() {
        //not yet implemented
    }
}