# VO2MAX Calculator - Installation & Usage Guide

## APK File Information

**File Name:** `VO2Max-Installer.apk`  
**File Size:** 916 KB  
**Android Version Required:** Android 5.0 (API 21) or higher  
**Supported:** All modern Android devices

## Installation Instructions

### Method 1: Direct Installation (Easiest)

1. **Transfer the APK to your Android device**
   - Connect your phone to your computer via USB
   - Copy `VO2Max-Installer.apk` to your device storage
   - Or email the APK to yourself

2. **Enable installation from unknown sources**
   - On your Android device, go to: **Settings** → **Security** → **Unknown Sources** (or **Install Unknown Apps**)
   - Enable this option

3. **Install the APK**
   - Open your file manager on the phone
   - Navigate to where you saved `VO2Max-Installer.apk`
   - Tap on it to begin installation
   - Accept the permissions and installation will complete

4. **Launch the app**
   - The app will appear in your app drawer as "VO2MAX Calculator"
   - Tap to open

### Method 2: Using ADB (Advanced)

If you have Android SDK Platform Tools installed:

```bash
adb install VO2Max-Installer.apk
```

### Method 3: Using Android Studio

1. Connect your Android device to your computer
2. In Android Studio, go to **Run** → **Select Device**
3. Choose your connected device and install

## Using the VO2MAX Calculator

### Step-by-Step Guide

1. **Open the app** on your Android device
2. **Select your gender**: Choose "Male" or "Female"
3. **Enter your age** in years (whole number)
4. **Enter your weight** in kilograms (kg)
5. **Enter your height** in meters (m) - e.g., 1.78
6. **Enter your heart rate** - Measure your pulse immediately after completing the 2 km walk (beats per minute)
7. **Enter walking time** - Time in decimal format:
   - Example: 15 minutes and 45 seconds = **15.75**
   - Formula: Minutes + (Seconds ÷ 60)
   - 15 + (45 ÷ 60) = 15 + 0.75 = 15.75
8. **Tap "Calculate VO2MAX"** button
9. **View results** - The app displays your VO2MAX value and all input parameters

### Example Calculation

```
Input:
- Gender: Male
- Age: 35 years
- Weight: 75 kg
- Height: 1.78 m
- Heart Rate: 140 bpm
- Walking Time: 16.5 minutes

Output:
VO2MAX: 48.32 ml•kg⁻¹•min⁻¹
```

## Understanding Your VO2MAX Results

VO2MAX is measured in **ml•kg⁻¹•min⁻¹** (milliliters of oxygen per kilogram of body weight per minute)

### VO2MAX Classification for Men

| Classification | VO2MAX (ml•kg⁻¹•min⁻¹) |
|---|---|
| Poor | < 25 |
| Fair | 25-35 |
| Average | 35-45 |
| Good | 45-55 |
| Excellent | 55-65 |
| Superior | > 65 |

### VO2MAX Classification for Women

| Classification | VO2MAX (ml•kg⁻¹•min⁻¹) |
|---|---|
| Poor | < 22 |
| Fair | 22-32 |
| Average | 32-42 |
| Good | 42-52 |
| Excellent | 52-60 |
| Superior | > 60 |

## Testing Conditions

For accurate results, ensure:
- Complete the 2 km walk at a moderate, steady pace
- Measure your heart rate immediately after finishing (within 5-10 seconds)
- Record the total time it took to complete the 2 km walk
- Be in good health with no recent illness
- Avoid exercise 24 hours before the test

## Important Notes

- This app uses the **Rockport Walking Test formula**
- Results are estimations based on the provided formulas
- Results may vary based on fitness level, terrain, and weather conditions  
- For medical evaluation, consult a healthcare professional
- Do not perform strenuous testing if you have health concerns

## Troubleshooting

### App won't install
- Ensure Android 5.0 or higher is installed on your device
- Enable "Unknown Sources" in Security settings
- Try clearing the Play Store cache: Settings → Apps → Play Store → Storage → Clear Cache

### App crashes on startup
- Uninstall and reinstall the app
- Restart your device
- Ensure sufficient storage space available

### Incorrect calculation
- Verify all input values are correct
- Ensure heart rate is measured immediately after walking
- Re-check the walking time conversion to decimal format

## Feedback & Support

For issues or suggestions:
- Android Version: Check that your device is running Android 5.0+
- Permissions: The app requires no special permissions

## Technical Details

- **Developed with:** Android Java SDK
- **Target SDK Version:** 21+
- **Minimum SDK Version:** 21 (Android 5.0)
- **Architecture:** ARM64, ARM, x86
- **No ads, no tracking, no permissions required**

## Formulas Used

**For Men:**
$$VO2\,max = 184.9 - 4.65T - 0.22HR - 0.26A - 1.05(BMI)$$

**For Women:**
$$VO2\,max = 116.2 - 2.98T - 0.11HR - 0.14A - 0.39(BMI)$$

Where:
- T = Walking time in minutes (decimal)
- HR = Final heart rate (beats per minute)
- A = Age (years)
- BMI = Body Mass Index = Weight (kg) / [Height (m)]²

## References

- Kline, G. M., et al. (1987). "Estimation of VO2max from a one-mile track walk, gender, age, and body weight." Medicine and Science in Sports and Exercise, 19(3), 253-259.
- Rockport Fitness Test: https://en.wikipedia.org/wiki/Rockport_fitness_test

---

**Version:** 1.0  
**Last Updated:** March 2026  
**License:** Personal Use

Enjoy tracking your cardiovascular fitness!
