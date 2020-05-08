package com.example.midterm1.api.dto

import com.google.gson.annotations.SerializedName

data class Post(
    val userId: Long,
    val id: Long,
    val title: String,
    val body: String
)

data class Comment(
    val postId: Long,
    val id: Long,
    val name: String,
    val email: String,
    val body: String
)

data class User(
    val id: Long,
    val username: String
)