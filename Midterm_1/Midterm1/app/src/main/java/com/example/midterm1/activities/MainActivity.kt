package com.example.midterm1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm1.R
import com.example.midterm1.adapters.PostAdapter
import com.example.midterm1.api.RetrofitClient
import com.example.midterm1.api.dto.Post
import com.example.midterm1.api.dto.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.initRecycler()

        this.getPosts()

        this.getUsers()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        postList.layoutManager = layoutManager
        postAdapter = PostAdapter(ArrayList(), ArrayList())
        postList.adapter = postAdapter
    }

    private fun getPosts() {
        RetrofitClient.reqResApi.getPosts("posts").enqueue(object: Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                val intent = Intent(this@MainActivity, error::class.java)
                startActivity(intent)
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    postAdapter.updatePosts(response.body()!!)
                }
            }

        })

    }

    private fun getUsers() {
        RetrofitClient.reqResApi.getUsers("users").enqueue(object: Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                val intent = Intent(this@MainActivity, error::class.java)
                startActivity(intent)
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && response.body() != null) {
                    postAdapter.updateUsers(response.body()!!)
                }
            }

        })

    }

}


