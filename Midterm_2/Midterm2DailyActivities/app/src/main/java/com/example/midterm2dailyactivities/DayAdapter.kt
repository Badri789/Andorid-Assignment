package com.example.midterm2dailyactivities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class DayAdapter(private val days: List<Day>)
    : RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(day: Day) {
            itemView.dayNumber.text = "Day: ${day.dayId}"
            itemView.numberOfStepsDay.text = "Number of Steps: ${day.numberOfSteps}"
            itemView.amountOfWaterDay.text = "Amount of Water: ${day.amountOfWater}L"
            itemView.hoursOfSleepDay.text = "Hours of Sleep: ${day.hoursOfSleep}h"
            itemView.amountOfCaloriesDay.text = "Amount of Calories: ${day.amountOfCalories}Cal"
            itemView.hoursOfTrainingDay.text = "Hours of Training: ${day.hoursOfTraining}h"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return DayViewHolder(v)
    }

    override fun getItemCount(): Int = days.size

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(days[position])
    }

}