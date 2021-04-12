package com.application.kitchenapp.view.base

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.StyleableRes


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version BaseRichView, v 0.1 31/03/21 13.27 by Richo Mahardika
 */
abstract class BaseRichView : FrameLayout {
    private var view: View? = null
    private var styledAttributes: TypedArray? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context, attrs: AttributeSet?, defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs)
    }

    protected fun init(context: Context?, attrs: AttributeSet?) {
        var isInjected = false

        if (!isInEditMode) {
            isInjected = true
        }

        view = inflate(context, getLayout(), this)

        onInjectedView(view)
        parseAttrs(context, attrs)
        setup(isInEditMode)

        if (!isInEditMode) {
            injected(isInjected)
        }

        setSingleClick()
    }

    protected fun isForRecyclerViewholder(): Boolean {
        return false
    }

    abstract fun getLayout(): Int

    protected fun onInjectedView(view: View?) {
        // Implementation to overide
    }

    protected fun parseAttrs(context: Context?, attrs: AttributeSet?) {}

    protected fun setup(isInEditMode: Boolean) {
        setup()
    }

    protected fun injected(isInjected: Boolean) {}

    abstract fun setup()

    protected fun setSingleClick() {
        //no implementation in base
    }

    protected fun onSingleClick(v: View?) {
        //no implementation in base
    }

//    fun getBaseActivity(): BaseActivity? {
//        return if (context is BaseActivity) {
//            context as BaseActivity
//        } else null
//    }

    protected fun getStyledAtrributesString(@StyleableRes res: Int): String? {
        return styledAttributes!!.getString(res)
    }

    protected fun getStyledAttributes(): TypedArray? {
        return styledAttributes
    }

    protected fun setStyledAttributes(
        context: Context, attrs: AttributeSet?,
        @StyleableRes stylableRes: IntArray?
    ) {
        styledAttributes = context.obtainStyledAttributes(attrs, stylableRes)
    }

    protected fun getView(): View? {
        return view
    }
}