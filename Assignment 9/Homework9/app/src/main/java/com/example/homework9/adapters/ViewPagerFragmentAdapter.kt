package com.example.homework9.adapters

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.homework9.fragments.FragmentFirst
import com.example.homework9.fragments.FragmentSecond
import com.example.homework9.fragments.FragmentThird

class ViewPagerFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FragmentFirst()
            1 -> FragmentSecond().apply {
                arguments = Bundle().apply {
                    putString("STRING", "123TEXT")
                }
            }
            2 -> FragmentThird()
            else -> FragmentFirst()
        }
    }

}