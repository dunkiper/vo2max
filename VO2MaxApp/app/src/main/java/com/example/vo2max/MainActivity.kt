package com.example.vo2max

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var ageInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var heightInput: EditText
    private lateinit var heartRateInput: EditText
    private lateinit var timeInput: EditText
    private lateinit var calculateBtn: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        ageInput = findViewById(R.id.ageInput)
        weightInput = findViewById(R.id.weightInput)
        heightInput = findViewById(R.id.heightInput)
        heartRateInput = findViewById(R.id.heartRateInput)
        timeInput = findViewById(R.id.timeInput)
        calculateBtn = findViewById(R.id.calculateBtn)
        resultTextView = findViewById(R.id.resultTextView)

        calculateBtn.setOnClickListener {
            calculateVO2Max()
        }
    }

    private fun calculateVO2Max() {
        try {
            // Get selected gender
            val selectedId = genderRadioGroup.checkedRadioButtonId
            if (selectedId == -1) {
                resultTextView.text = "Please select a gender"
                return
            }

            val isMale = selectedId == R.id.maleRadio

            // Get input values
            val age = ageInput.text.toString().toDoubleOrNull()
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()
            val heartRate = heartRateInput.text.toString().toDoubleOrNull()
            val time = timeInput.text.toString().toDoubleOrNull()

            // Validate inputs
            if (age == null || weight == null || height == null || 
                heartRate == null || time == null) {
                resultTextView.text = "Please fill all fields with valid numbers"
                return
            }

            // Calculate BMI (weight in kg / height in m^2)
            val bmi = weight / (height * height)

            // Calculate VO2MAX based on gender
            val vo2max = if (isMale) {
                // Men: VO2máx = 184,9 – 4,65T – 0,22HR – 0,26A – 1,05IMC
                184.9 - (4.65 * time) - (0.22 * heartRate) - (0.26 * age) - (1.05 * bmi)
            } else {
                // Women: VO2máx = 116,2 – 2,98T – 0,11HR – 0,14A – 0,39IMC
                116.2 - (2.98 * time) - (0.11 * heartRate) - (0.14 * age) - (0.39 * bmi)
            }

            // Display result
            val gender = if (isMale) "Male" else "Female"
            resultTextView.text = String.format(
                """
                VO2MAX Calculation Results
                
                Gender: %s
                Age: %.1f years
                Weight: %.1f kg
                Height: %.2f m
                Heart Rate: %.0f bpm
                Walking Time: %.2f minutes
                BMI: %.2f
                
                VO2MAX: %.2f ml•kg⁻¹•min⁻¹
                """.trimIndent(),
                gender, age, weight, height, heartRate, time, bmi, vo2max
            )

        } catch (e: Exception) {
            resultTextView.text = "Error: ${e.message}"
        }
    }
}
