package com.application.kitchenapp.view.base

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * @author Richo Mahardika (richo.mahardika@dana.id)
 * @version BasePagerAdapter, v 0.1 04/04/21 11.22 by Richo Mahardika
 */
class BasePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    var fragments: ArrayList<Fragment> = ArrayList()
    var tabTitles: ArrayList<String> = ArrayList()

    fun addFragments(fragment: Fragment?, tabTitle: String?) {
        fragments.add(fragment ?: return)
        tabTitles.add(tabTitle.orEmpty())
    }

    override fun destroyItem(container: ViewGroup, position: Int, item: Any) {
        container.removeView(item as View)
    }

    override fun getPageTitle(position: Int) = tabTitles[position]
    override fun getItem(position: Int) = fragments[position]
    override fun getCount() = fragments.size
}