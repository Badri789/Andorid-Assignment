package com.example.midterm2dailyactivities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DAYS")
data class Day(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "DayId")
    val dayId: Long,

    @ColumnInfo(name = "NumberOfSteps")
    val numberOfSteps: Long,

    @ColumnInfo(name = "AmountOfWater")
    val amountOfWater: Double,

    @ColumnInfo(name = "HoursOfSleep")
    val hoursOfSleep: Double,

    @ColumnInfo(name = "AmountOfCalories")
    val amountOfCalories: Long,

    @ColumnInfo(name = "HoursOfTraining")
    val hoursOfTraining: Double

)
