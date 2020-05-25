package com.example.homework8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTES")
data class Note(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "NoteId")
    val noteId: Long,

    @ColumnInfo(name = "NoteBody")
    val noteBody: String?
)


