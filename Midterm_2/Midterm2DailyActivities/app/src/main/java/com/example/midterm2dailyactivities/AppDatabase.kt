package com.example.midterm2dailyactivities

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Day::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDayDao(): DayDao
}



