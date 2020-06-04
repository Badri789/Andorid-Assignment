package com.example.midterm2dailyactivities

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface DayDao {

    @Query("SELECT * FROM DAYS")
    fun getAllDays(): List<Day>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDay(vararg days: Day)

    @Query("DELETE FROM DAYS")
    fun deleteAllDays()

    @RawQuery
    fun getStatOfActivity(query: SupportSQLiteQuery): Double

}

