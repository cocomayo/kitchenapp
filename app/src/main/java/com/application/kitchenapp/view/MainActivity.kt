package com.application.kitchenapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.application.kitchenapp.R
import com.application.kitchenapp.view.base.BasePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version MainActivity, v 0.1 05/04/21 15.59 by Richo Mahardika
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = vp_main
        viewPager.currentItem = 0

        val viewPagerAdapter = BasePagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragments(DashboardFragment(), "Dashboard")
        viewPagerAdapter.addFragments(CourierFragment(), "Courier")

        viewPager.adapter = viewPagerAdapter
    }
}