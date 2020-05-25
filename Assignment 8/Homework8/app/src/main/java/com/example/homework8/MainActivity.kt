package com.example.homework8
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter
    private lateinit var notesFromDb: List<Note>
    private  val notesBodies: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(customToolbar)

        notesFromDb = App.instance.db.getNoteDao().getAllNotes()

        notesFromDb.asReversed().forEach {
            notesBodies.add(it.noteBody.toString())
        }

        initRecycler(notesBodies)

        addBtn.setOnClickListener {
            val note = inputText.text.toString()
            noteAdapter.addNote(note)
            App.instance.db.getNoteDao().insertNote(Note(0, note))
            inputText.setText("")
        }
    }

    private fun initRecycler(notes: MutableList<String>) {
        val layoutManager = LinearLayoutManager(this)
        notesRecycler.layoutManager = layoutManager
        noteAdapter = NoteAdapter(notes)
        notesRecycler.adapter = noteAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        App.instance.db.getNoteDao().deleteAll()
        noteAdapter.updateNotes(mutableListOf())
        return super.onOptionsItemSelected(item)
    }
}




