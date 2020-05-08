package com.example.midterm1.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm1.R
import com.example.midterm1.api.dto.Comment
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentAdapter(private var comments: List<Comment>) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var comment: Comment

        @SuppressLint("SetTextI18n")
        fun bind(comment: Comment) {
            this.comment = comment

            itemView.commentName.text = "Comment Name: ${comment.name}"
            itemView.commentEmail.text = "Email: ${comment.email}"
            itemView.commentBody.text = comment.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(v)
    }

    override fun getItemCount(): Int = comments.size

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])
    }

    fun updateComments(comments: List<Comment>) {
        this.comments = comments
        notifyDataSetChanged()
    }
}

