package com.application.kitchenapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.application.kitchenapp.R
import com.application.kitchenapp.model.SectionModel
import com.application.kitchenapp.view.adapter.DashboardRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        DashboardRecyclerViewAdapter().apply {
            rv_dashboard?.adapter = this
            rv_dashboard?.layoutManager = LinearLayoutManager(context)

            setItems(SectionModel("Overall", "PREPARING 017"))
            setItems(SectionModel("Kitchen", "PREPARING 017"))
            setItems(SectionModel("Shelves", "PREPARING 017"))
            setItems(SectionModel("Courier", "PREPARING 017"))
        }
    }
}