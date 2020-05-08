package com.example.midterm1.adapters
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm1.R
import com.example.midterm1.activities.CommentActivity
import com.example.midterm1.api.dto.Post
import com.example.midterm1.api.dto.User
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(private var posts: List<Post>, private var users: List<User>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        private lateinit var post: Post
        private lateinit var users: List<User>

        @SuppressLint("SetTextI18n")
        fun bind(post: Post, users: List<User>) {
            this.post = post
            this.users = users

            itemView.userName.text = "UserName: ${users.filter { it.id == post.userId }[0].username}"

            itemView.commentPostId.text = "Post ID: ${post.id}"

            itemView.title.text = post.title

            itemView.body.text = post.body

        }

        override fun onClick(v: View?) {
            val context = itemView.context
            val intent = Intent(context, CommentActivity::class.java)
            intent.putExtra("POST_ID", post.id)
            context.startActivity(intent)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(v)

    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position], users)
    }

    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    fun updateUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

}