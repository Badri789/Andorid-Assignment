package com.example.homework8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_item.view.*

class NoteAdapter(private var notes: MutableList<String>)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: String) {
            itemView.noteText.text = note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return NoteViewHolder(v)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    fun addNote(note: String) {
        notes.add(0, note)
        notifyDataSetChanged()
    }

    fun updateNotes(notes: MutableList<String>) {
        this.notes = notes
        notifyDataSetChanged()
    }



}