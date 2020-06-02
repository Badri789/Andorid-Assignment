package com.example.homework9.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework9.R
import kotlinx.android.synthetic.main.fragment_second.*

class FragmentSecond : Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf {
            it.containsKey("STRING")
        }?.apply { textView2.text = getString("STRING") }
    }


}