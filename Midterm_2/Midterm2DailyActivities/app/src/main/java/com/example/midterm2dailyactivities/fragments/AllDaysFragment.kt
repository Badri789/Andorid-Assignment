package com.example.midterm2dailyactivities.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm2dailyactivities.App
import com.example.midterm2dailyactivities.Day
import com.example.midterm2dailyactivities.DayAdapter
import com.example.midterm2dailyactivities.R
import kotlinx.android.synthetic.main.fragment_all_days.*

class AllDaysFragment : Fragment(R.layout.fragment_all_days) {

    private lateinit var days: List<Day>
    private lateinit var dayAdapter: DayAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        days = App.instance.db.getDayDao().getAllDays()

        val layoutManager = LinearLayoutManager(context)
        daysRecycler.layoutManager = layoutManager
        dayAdapter = DayAdapter(days)
        daysRecycler.adapter = dayAdapter
    }
}