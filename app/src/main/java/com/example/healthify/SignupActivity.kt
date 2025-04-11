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

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val name = findViewById<EditText>(R.id.name_sign)
        val email = findViewById<EditText>(R.id.email_sign)
        val password = findViewById<EditText>(R.id.pass_sign)
        val phone_number = findViewById<EditText>(R.id.ph_sign)
        val dob = findViewById<EditText>(R.id.dob_sign)
        val submit = findViewById<Button>(R.id.submit1)



        submit.setOnClickListener(){
            val userName = name.text.toString().trim()
            val userEmail = email.text.toString().trim()
            val userPassword = password.text.toString().trim()
            val userPhone = phone_number.text.toString().trim()
            val userDob = dob.text.toString().trim()

            if (userName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty() || userPhone.isEmpty() || userDob.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Sending Data to LoginActivity
            val intent = Intent(this, LoginActivity::class.java).apply {
                putExtra("USER_NAME", userName)
                putExtra("USER_EMAIL", userEmail)
                putExtra("USER_PASSWORD", userPassword)
                putExtra("USER_PHONE_NUMBER", userPhone)
                putExtra("USER_DOB", userDob)
            }
            startActivity(intent)

        }
    }
}