package com.example.midterm2dailyactivities.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.midterm2dailyactivities.App
import com.example.midterm2dailyactivities.R
import kotlinx.android.synthetic.main.fragment_statistic.*
import kotlin.math.roundToInt

class StatisticFragment : Fragment(R.layout.fragment_statistic) {

    private var totalSteps: Long = 0
    private var averageSteps: Double = 0.0

    private var totalWater: Double = 0.0
    private var averageWater: Double = 0.0

    private var totalHoursSleep: Double = 0.0
    private var averageHoursSleep: Double = 0.0

    private var totalCalories: Long = 0
    private var averageCalories: Double = 0.0

    private var totalHoursTraining: Double = 0.0
    private var averageHoursTraining: Double = 0.0

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = App.instance.db.getDayDao()

        //Steps
        totalSteps =
            database.getStatOfActivity(generateTotalQuery("NumberOfSteps")).toLong()
        averageSteps =
            database.getStatOfActivity(generateAverageQuery("NumberOfSteps"))
        averageSteps = (averageSteps * 100).roundToInt() / 100.0

        //Water
        totalWater =
            database.getStatOfActivity(generateTotalQuery("AmountOfWater"))
        averageWater =
            database.getStatOfActivity(generateAverageQuery("AmountOfWater"))
        averageWater = (averageWater * 100).roundToInt() / 100.0

        //Sleep
        totalHoursSleep =
            database.getStatOfActivity(generateTotalQuery("HoursOfSleep"))
        averageHoursSleep =
            database.getStatOfActivity(generateAverageQuery("HoursOfSleep"))
        averageHoursSleep = (averageHoursSleep * 100).roundToInt() / 100.0

        //Calories
         totalCalories =
             database.getStatOfActivity(generateTotalQuery("AmountOfCalories")).toLong()
         averageCalories =
             database.getStatOfActivity(generateAverageQuery("AmountOfCalories"))
         averageCalories = (averageCalories * 100).roundToInt() / 100.0

        //Training
        totalHoursTraining =
            database.getStatOfActivity(generateTotalQuery("HoursOfTraining"))
        averageHoursTraining =
            database.getStatOfActivity(generateAverageQuery("HoursOfTraining"))
        averageHoursTraining = (averageHoursTraining * 100).roundToInt() / 100.0


        totalStepsStat.text = "Total number of Steps: $totalSteps"
        averageStepsStat.text = "Average Steps per day: $averageSteps"

        totalWaterStat.text = "Total amount of Water: ${totalWater}L"
        averageWaterStat.text = "Average Water per day: ${averageWater}L"

        totalHoursSleepStat.text = "Total Hours of sleep: ${totalHoursSleep}h"
        averageHoursSleepStat.text = "Average Hours of sleep per day: ${averageHoursSleep}h"

        totalCaloriesStat.text = "Total amount of Calories: ${totalCalories}Cal"
        averageCaloriesStat.text = "Average Calories per day: ${averageCalories}Cal"

        totalCaloriesStat.text = "Total amount of Calories: ${totalCalories}Cal"
        averageCaloriesStat.text = "Average Calories per day: ${averageCalories}Cal"

        totalHoursTrainStat.text = "Total Hours of training: ${totalHoursTraining}h"
        averageHoursTrainStat.text = "Average Hours of training per day: ${averageHoursTraining}h"

    }

    private fun generateTotalQuery(colName: String): SimpleSQLiteQuery {
        return SimpleSQLiteQuery("SELECT SUM($colName) FROM DAYS");
    }

    private fun generateAverageQuery(colName: String): SimpleSQLiteQuery {
        return SimpleSQLiteQuery("SELECT AVG($colName) FROM DAYS");
    }


}