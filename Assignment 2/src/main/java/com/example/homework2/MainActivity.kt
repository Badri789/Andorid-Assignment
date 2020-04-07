package com.example.homework2

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myTextView: TextView = findViewById(R.id.textView2)
        val text = "Don't have an account? Sign up!"
        val ss = SpannableString(text)
        val boldspan = StyleSpan(Typeface.BOLD)
        ss.setSpan(boldspan, 23, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        myTextView.text = ss
    }
}
