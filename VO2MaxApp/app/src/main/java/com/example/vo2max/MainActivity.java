package com.example.vo2max;

import android.app.Activity;
import android.content.SharedPreferences;
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
    private SharedPreferences sharedPreferences;

    private static final String PREFS_NAME = "VO2MaxPrefs";
    private static final String PREF_GENDER = "gender";
    private static final String PREF_AGE = "age";
    private static final String PREF_WEIGHT = "weight";
    private static final String PREF_HEIGHT = "height";
    private static final String PREF_HEART_RATE = "heartRate";
    private static final String PREF_TIME = "time";
    private static final String PREF_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // Initialize views
        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        ageInput = (EditText) findViewById(R.id.ageInput);
        weightInput = (EditText) findViewById(R.id.weightInput);
        heightInput = (EditText) findViewById(R.id.heightInput);
        heartRateInput = (EditText) findViewById(R.id.heartRateInput);
        timeInput = (EditText) findViewById(R.id.timeInput);
        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        resultTextView = (TextView) findViewById(R.id.resultTextView);

        // Load saved values
        loadSavedValues();

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
            double time = parseTimeInput(timeInput.getText().toString());

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
            String timeDisplay = formatTimeFromDecimal(time);
            String result = String.format(
                    "VO2MAX Calculation Results\n\n" +
                    "Gender: %s\n" +
                    "Age: %.1f years\n" +
                    "Weight: %.1f kg\n" +
                    "Height: %.2f m\n" +
                    "Heart Rate: %.0f bpm\n" +
                    "Walking Time: %s\n" +
                    "BMI: %.2f\n\n" +
                    "VO2MAX: %.2f ml·kg^-1·min^-1",
                    gender, age, weight, height, heartRate, timeDisplay, bmi, vo2max
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

    private double parseTimeInput(String value) {
        try {
            if (value.contains(":")) {
                // Parse mm:ss format
                String[] parts = value.split(":");
                if (parts.length != 2) {
                    return Double.NaN;
                }
                int minutes = Integer.parseInt(parts[0].trim());
                int seconds = Integer.parseInt(parts[1].trim());
                
                if (seconds < 0 || seconds >= 60) {
                    return Double.NaN;
                }
                
                return minutes + (seconds / 60.0);
            } else {
                // Fall back to decimal format for backward compatibility
                return Double.parseDouble(value);
            }
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

    private String formatTimeFromDecimal(double decimalMinutes) {
        int minutes = (int) decimalMinutes;
        int seconds = (int) Math.round((decimalMinutes - minutes) * 60);
        
        // Handle case where rounding brings seconds to 60
        if (seconds == 60) {
            minutes++;
            seconds = 0;
        }
        
        return String.format("%d:%02d", minutes, seconds);
    }

    private void loadSavedValues() {
        // Load gender
        int savedGender = sharedPreferences.getInt(PREF_GENDER, -1);
        if (savedGender != -1) {
            genderRadioGroup.check(savedGender);
        }

        // Load text input fields
        String savedAge = sharedPreferences.getString(PREF_AGE, "");
        String savedWeight = sharedPreferences.getString(PREF_WEIGHT, "");
        String savedHeight = sharedPreferences.getString(PREF_HEIGHT, "");
        String savedHeartRate = sharedPreferences.getString(PREF_HEART_RATE, "");
        String savedTime = sharedPreferences.getString(PREF_TIME, "");

        ageInput.setText(savedAge);
        weightInput.setText(savedWeight);
        heightInput.setText(savedHeight);
        heartRateInput.setText(savedHeartRate);
        timeInput.setText(savedTime);

        // Load and display previous result
        String savedResult = sharedPreferences.getString(PREF_RESULT, "");
        if (!savedResult.isEmpty()) {
            resultTextView.setText(savedResult);
        }
    }

    private void saveSavedValues() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save gender
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        editor.putInt(PREF_GENDER, selectedGenderId);

        // Save text input fields
        editor.putString(PREF_AGE, ageInput.getText().toString());
        editor.putString(PREF_WEIGHT, weightInput.getText().toString());
        editor.putString(PREF_HEIGHT, heightInput.getText().toString());
        editor.putString(PREF_HEART_RATE, heartRateInput.getText().toString());
        editor.putString(PREF_TIME, timeInput.getText().toString());

        // Save result
        editor.putString(PREF_RESULT, resultTextView.getText().toString());

        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveSavedValues();
    }
}
