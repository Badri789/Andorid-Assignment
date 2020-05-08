package com.example.midterm1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm1.R
import com.example.midterm1.adapters.CommentAdapter
import com.example.midterm1.api.RetrofitClient
import com.example.midterm1.api.dto.Comment
import kotlinx.android.synthetic.main.activity_comment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.properties.Delegates

class CommentActivity : AppCompatActivity() {

    private lateinit var commentAdapter: CommentAdapter
    private var postId by Delegates.notNull<Long>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        postId = intent.extras?.getLong("POST_ID")!!

        this.initRecycler()

        this.getAllComments()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        commentList.layoutManager = layoutManager
        commentAdapter = CommentAdapter(ArrayList())
        commentList.adapter = commentAdapter
    }

    private fun getAllComments() {
        RetrofitClient.reqResApi.getComments(postId).enqueue(object : Callback<List<Comment>> {
            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                val intent = Intent(this@CommentActivity, error::class.java)
                startActivity(intent)
            }

            override fun onResponse(
                call: Call<List<Comment>>,
                response: Response<List<Comment>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    commentAdapter.updateComments(response.body()!!)
                }
            }

        })
    }


}
