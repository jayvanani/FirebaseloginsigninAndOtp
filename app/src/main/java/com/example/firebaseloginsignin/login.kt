package com.example.firebaseloginsignin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var emllog: TextInputEditText
    lateinit var passlog: TextInputEditText
    lateinit var login: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emllog = findViewById(R.id.emllog)
        passlog = findViewById(R.id.passlog)
        auth = Firebase.auth
        login = findViewById(R.id.login)


        login.setOnClickListener {
            loginuser()
        }
    }

    private fun loginuser() {
        auth.signInWithEmailAndPassword(emllog.text.toString(), passlog.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("==========", "signInWithEmail:success")
                    val user = auth.currentUser
//                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("-=-=-=-=", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
//                    updateUI(null)
                }
            }
    }
}