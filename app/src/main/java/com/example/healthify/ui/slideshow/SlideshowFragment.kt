package com.example.healthify.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.healthify.databinding.FragmentSlideshowBinding
import kotlin.toString

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //Observe the text and set it to the correct textview
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            binding.bmiCalc.text = it
        }

        //Get the views from the binding object
        val weightInput: EditText = binding.weightInput
        val heightInput: EditText = binding.heightInput
        val calculateButton: Button = binding.calculateButton
        val resultText: TextView = binding.resultText

        //Add functionality to the calculateButton here.
        calculateButton.setOnClickListener {
            calculateBMI(weightInput, heightInput, resultText)
        }

        return root
    }

    private fun calculateBMI(weightInput: EditText, heightInput: EditText, resultText: TextView) {
        val weight = weightInput.text.toString().toFloatOrNull()
        val height = heightInput.text.toString().toFloatOrNull()

        if (weight != null && height != null && height > 0) {
            val bmi = weight / (height * height)
            //Get the correct string from the when statement
            val bmiCategory = when {
                bmi < 18.5 -> {
                    "Underweight"
                }
                bmi in 18.5..24.9 -> {
                    "Normal weight"
                }
                bmi in 25.0..29.9 -> {
                    "Overweight"
                }
                else -> {
                    "Obese"
                }
            }
            //Display both the bmi value and the category
            resultText.text = String.format("BMI: %.2f\nCategory: %s", bmi, bmiCategory)
        } else {
            resultText.text = "Invalid input"
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}