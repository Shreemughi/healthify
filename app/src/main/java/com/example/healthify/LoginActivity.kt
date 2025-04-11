package com.example.healthify

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.healthify.ui.home.HomeViewModel

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lbutton = findViewById<Button>(R.id.login)
        val sbutton = findViewById<Button>(R.id.signup)
        val email = findViewById<EditText>(R.id.email_log)
        val password = findViewById<EditText>(R.id.pass_log)


        sbutton.setOnClickListener() {
            val intent = Intent(this, SignupActivity::class.java)

            startActivity(intent)
        }

        val userEmail = intent.getStringExtra("USER_EMAIL")
        val userPassword = intent.getStringExtra("USER_PASSWORD")

        lbutton.setOnClickListener {
            val enteredEmail = email.text.toString().trim()
            val enteredPassword = password.text.toString().trim()
            // Check if fields are empty
            if (enteredEmail.isEmpty() || enteredPassword.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            // Check if credentials match
            if (enteredEmail == userEmail && enteredPassword == userPassword) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()

                // Navigate to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}