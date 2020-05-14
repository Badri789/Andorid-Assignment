package com.example.homework6.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework6.R
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment(R.layout.fragment_notifications) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.textView2.text = NotificationsFragmentArgs.fromBundle(requireArguments()).amount.toString()
    }
}