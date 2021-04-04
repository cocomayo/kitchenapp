package com.application.kitchenapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.kitchenapp.R
import com.application.kitchenapp.processor.OrderProcessor
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    private var counter = 0

    private val orderProcessor by lazy {
        OrderProcessor(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        orderProcessor.processOrder {
            view_sectionCard.setReportText(it)
        }
    }
}