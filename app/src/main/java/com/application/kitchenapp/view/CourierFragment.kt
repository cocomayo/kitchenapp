package com.application.kitchenapp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.application.kitchenapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*


class CourierFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        tv_title?.text = "uhuy"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)
}