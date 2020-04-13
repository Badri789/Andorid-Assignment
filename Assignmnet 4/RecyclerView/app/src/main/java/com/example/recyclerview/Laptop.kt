package com.example.recyclerview

import androidx.annotation.DrawableRes

data class Laptop (
    val id: Int,
    val title: String,
    val price: String,
    @DrawableRes
    val logo: Int
)