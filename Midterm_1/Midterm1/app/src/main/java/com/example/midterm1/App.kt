package com.example.midterm1

import android.app.Application
import com.example.midterm1.api.RetrofitClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }

}