package com.example.tablayout

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragments: List<Fragment>,
    lifecycle: Lifecycle,
    fm: FragmentManager,
) : FragmentStateAdapter(fm, lifecycle) {

    private val fragmentList: List<Fragment> = fragments

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]

}