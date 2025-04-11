package com.example.healthify


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Get data from Intent
        val patientName = intent.getStringExtra("EXTRA_NAME")
        val patientAge = intent.getStringExtra("EXTRA_AGE")
        val gender = intent.getStringExtra("EXTRA_GENDER")
        val symptoms = intent.getStringExtra("EXTRA_SYMPTOMS")
        val appointmentDate = intent.getStringExtra("EXTRA_DATE")

        // Reference TextView
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Display the data
        val resultText = """
            Patient Name: $patientName
            Age: $patientAge
            Gender: $gender
            Symptoms: $symptoms
            Appointment Date: $appointmentDate
        """.trimIndent()

        tvResult.text = resultText
    }
}
