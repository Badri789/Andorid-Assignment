package com.example.homework7

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter
    private var noteSet: MutableSet<String> = mutableSetOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("MyApplication", Context.MODE_PRIVATE)
        val savedNotes = sharedPreferences.getStringSet("NOTES", setOf<String>())
        if (savedNotes != null) {
            noteSet = savedNotes.toMutableSet()
        }

        initRecycler(noteSet)

        addBtn.setOnClickListener {
            val note = inputText.text.toString()
            noteAdapter.addNote(note)
            noteSet.add(note)
            inputText.setText("")
            sharedPreferences.edit().putStringSet("NOTES", noteSet).apply()

        }
    }

    private fun initRecycler(noteSet: MutableSet<String>) {
        val layoutManager = LinearLayoutManager(this)
        notesRecycler.layoutManager = layoutManager
        noteAdapter = NoteAdapter(noteSet.toMutableList())
        notesRecycler.adapter = noteAdapter
    }

}
