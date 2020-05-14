package com.example.homework6

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework6.fragments.ChatFragment
import com.example.homework6.fragments.DashboardFragment
import com.example.homework6.fragments.HomeFragment
import com.example.homework6.fragments.NotificationsFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments: ArrayList<Fragment> = arrayListOf(
        HomeFragment(),
        DashboardFragment(),
        NotificationsFragment(),
        ChatFragment()
    )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}