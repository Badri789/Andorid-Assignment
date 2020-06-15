package com.example.homework10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerBtn.setOnClickListener {
            val email: String = emailAuth.text.toString()
            val password: String = passwordAuth.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener{task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "წარმატებით შეიქმნა!", Toast.LENGTH_LONG).show()
                            emailAuth.setText("")
                            passwordAuth.setText("")
                        } else {
                            Toast.makeText(this, "შეცდომა!", Toast.LENGTH_LONG).show()
                            emailAuth.setText("")
                            passwordAuth.setText("")
                        }
                    }
            }
        }
    }
}
