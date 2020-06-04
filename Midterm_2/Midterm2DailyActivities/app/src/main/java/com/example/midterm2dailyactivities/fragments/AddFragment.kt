package com.example.midterm2dailyactivities.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.midterm2dailyactivities.App
import com.example.midterm2dailyactivities.Day
import com.example.midterm2dailyactivities.R
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment(R.layout.fragment_add) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitActivities.setOnClickListener {

            if (
                TextUtils.isEmpty(numberOfSteps.text) ||
                TextUtils.isEmpty(amountOfWater.text) ||
                TextUtils.isEmpty(hoursOfSleep.text) ||
                TextUtils.isEmpty(amountOfCalories.text) ||
                TextUtils.isEmpty(hoursOfTraining.text)
            ) {
                Toast.makeText(context, "Please fill all fields!",
                    Toast.LENGTH_SHORT).show()
            } else {
                val day = Day(0,
                    numberOfSteps.text.toString().toLong(),
                    amountOfWater.text.toString().toDouble(),
                    hoursOfSleep.text.toString().toDouble(),
                    amountOfCalories.text.toString().toLong(),
                    hoursOfTraining.text.toString().toDouble()
                )

                App.instance.db.getDayDao().insertDay(day)

                numberOfSteps.setText("")
                amountOfWater.setText("")
                hoursOfSleep.setText("")
                amountOfCalories.setText("")
                hoursOfTraining.setText("")
            }
        }

    }

}