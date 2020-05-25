package com.example.homework8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface NoteDao {

    @Query("SELECT * FROM NOTES")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(vararg notes: Note)

    @Query("DELETE FROM NOTES")
    fun deleteAll()
}

