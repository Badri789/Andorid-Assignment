package com.example.midterm1.api

import com.example.midterm1.api.dto.Comment
import com.example.midterm1.api.dto.Post
import com.example.midterm1.api.dto.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReqResService {

    @GET("{posts}")
    fun getPosts(@Path("posts") posts: String) : Call<List<Post>>

    @GET("{users}")
    fun getUsers(@Path("users") users: String) : Call<List<User>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") id: Long) : Call<List<Comment>>


}