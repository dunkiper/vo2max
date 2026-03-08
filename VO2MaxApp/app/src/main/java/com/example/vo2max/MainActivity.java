package com.example.vo2max;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity {

    private RadioGroup genderRadioGroup;
    private EditText ageInput;
    private EditText weightInput;
    private EditText heightInput;
    private EditText heartRateInput;
    private EditText timeInput;
    private Button calculateBtn;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        ageInput = (EditText) findViewById(R.id.ageInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        heartRateInput = (EditText) findViewById(R.id.heartRateInput);
        timeInput = (EditText) findViewById(R.id.timeInput);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateVO2Max();
            }
        });
    }

    private void calculateVO2Max() {
        try {
            // Get selected gender
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                resultTextView.setText("Please select a gender");
                return;
            }

            boolean isMale = selectedId == R.id.maleRadio;

            // Get input values
            double age = parseDouble(ageInput.getText().toString());
            double weight = parseDouble(weightInput.getText().toString());
            double height = parseDouble(heightInput.getText().toString());
            double heartRate = parseDouble(heartRateInput.getText().toString());
            double time = parseDouble(timeInput.getText().toString());

            if (Double.isNaN(age) || Double.isNaN(weight) || Double.isNaN(height) ||
                    Double.isNaN(heartRate) || Double.isNaN(time)) {
                resultTextView.setText("Please fill all fields with valid numbers");
                return;
            }

            // Calculate BMI (weight in kg / height in m^2)
            double bmi = weight / (height * height);

            // Calculate VO2MAX based on gender
            double vo2max;
            if (isMale) {
                // Men: VO2máx = 184,9 – 4,65T – 0,22HR – 0,26A – 1,05IMC
                vo2max = 184.9 - (4.65 * time) - (0.22 * heartRate) - (0.26 * age) - (1.05 * bmi);
            } else {
                // Women: VO2máx = 116,2 – 2,98T – 0,11HR – 0,14A – 0,39IMC
                vo2max = 116.2 - (2.98 * time) - (0.11 * heartRate) - (0.14 * age) - (0.39 * bmi);
            }

            // Display result
            String gender = isMale ? "Male" : "Female";
            String result = String.format(
                    "VO2MAX Calculation Results\n\n" +
                    "Gender: %s\n" +
                    "Age: %.1f years\n" +
                    "Weight: %.1f kg\n" +
                    "Height: %.2f m\n" +
                    "Heart Rate: %.0f bpm\n" +
                    "Walking Time: %.2f minutes\n" +
                    "BMI: %.2f\n\n" +
                    "VO2MAX: %.2f ml·kg^-1·min^-1",
                    gender, age, weight, height, heartRate, time, bmi, vo2max
            );
            resultTextView.setText(result);

        } catch (Exception e) {
            resultTextView.setText("Error: " + e.getMessage());
        }
    }

    private double parseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }
}
