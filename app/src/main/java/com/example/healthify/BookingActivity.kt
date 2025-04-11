package com.example.healthify

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BookingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val etName: EditText = findViewById(R.id.et_patient_name)
        val etAge: EditText = findViewById(R.id.et_patient_age)
        val rgGender: RadioGroup = findViewById(R.id.radioGroup)
        val etSymptoms: EditText = findViewById(R.id.et_symptoms)
        val datePicker: DatePicker = findViewById(R.id.dp_appointment_date)
        val btnSubmit: Button = findViewById(R.id.book_submit)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val age = etAge.text.toString().trim()
            val symptoms = etSymptoms.text.toString().trim()
            val selectedGenderId = rgGender.checkedRadioButtonId

            val day = datePicker.dayOfMonth
            val month = datePicker.month + 1 // 0
            val year = datePicker.year
            val selectedDate = "$day/$month/$year"

            // Validation
            if (name.isBlank()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (age.isBlank()) {
                Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (symptoms.isBlank()) {
                Toast.makeText(this, "Please enter your symptoms", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            // Passing data to ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_GENDER", gender)
                putExtra("EXTRA_SYMPTOMS", symptoms)
                putExtra("EXTRA_DATE", selectedDate)
            }

            startActivity(intent)

            Toast.makeText(this, "Appointment Booked", Toast.LENGTH_SHORT).show()
        }
    }
}