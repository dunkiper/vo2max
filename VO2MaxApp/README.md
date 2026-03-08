# VO2MAX Calculator Android App

A simple Android application that calculates VO2MAX (maximum oxygen uptake) after a 2 km walk using the Rockport Walking Test formulas.

## Features

- Calculate VO2MAX for both men and women
- Input: Age, weight, height, final heart rate, and 2 km walking time
- Automatic BMI calculation
- Uses scientifically-validated formulas based on the Rockport Walking Test

## Formulas Used

**Men:** VO2máx = 184.9 – 4.65T – 0.22HR – 0.26A – 1.05IMC
**Women:** VO2máx = 116.2 – 2.98T – 0.11HR – 0.14A – 0.39IMC

Where:
- T = Walking time in minutes (decimal format)
- HR = Final heart rate in beats per minute
- A = Age in years
- IMC = BMI (Body Mass Index)

## Project Structure

```
VO2MaxApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/vo2max/
│   │       │   └── MainActivity.java
│   │       ├── res/
│   │       │   ├── layout/
│   │       │   │   └── activity_main.xml
│   │       │   ├── values/
│   │       │   │   └── strings.xml
│   │       │   └── drawable/
│   │       │       ├── ic_launcher.xml
│   │       │       └── result_background.xml
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
├── local.properties
├── README.md
└── Dockerfile (optional, for building in Docker)
```

## Building the APK

### Option 1: Using Android Studio (Recommended)

1. Download and install [Android Studio](https://developer.android.com/studio)
2. Open the project in Android Studio
3. Wait for Gradle sync to complete
4. Click **Build** > **Build Bundle(s) / APK(s)** > **Build APK(s)**
5. The APK will be generated at: `app/build/outputs/apk/debug/app-debug.apk`

### Option 2: Using Command Line (Gradle)

Requirements:
- Java Development Kit (JDK) 8 or higher
- Android SDK (API level 21+)
- Gradle 7.0 or higher

Steps:
```bash
cd VO2MaxApp

# Set Android SDK path if not already set
export ANDROID_SDK_ROOT=/path/to/android-sdk

# Build the APK
./gradlew assembleDebug

# APK output: app/build/outputs/apk/debug/app-debug.apk
```

### Option 3: Using Docker (One-click Build)

If you have Docker installed:

```bash
cd VO2MaxApp
docker build -t vo2max-builder .
docker run --rm -v $(pwd):/app vo2max-builder
```

The APK will be generated in `app/build/outputs/apk/debug/app-debug.apk`

## Installing the APK

Once built, install the APK on your Android device:

```bash
adb install app/build/outputs/apk/debug/app-debug.apk
```

Or simply transfer the APK file to your device and tap it to install.

## System Requirements

- Android 5.0 (API level 21) or higher
- Minimum display size: 4 inches

## Usage

1. Enter your gender (Male/Female)
2. Enter your age in years
3. Enter your weight in kilograms
4. Enter your height in meters  
5. Enter your final heart rate (measured after the 2 km walk)
6. Enter the time taken to walk 2 km in decimal format:
   - Example: 15 minutes 45 seconds = 15.75 minutes
7. Tap "Calculate VO2MAX"
8. The result will be displayed in ml•kg⁻¹•min⁻¹

## Example Calculation

- Gender: Male
- Age: 35 years
- Weight: 75 kg
- Height: 1.78 m  
- Heart Rate: 140 bpm
- Walking Time: 16.5 minutes

**Expected Result:** Approximately 45-50 ml•kg⁻¹•min⁻¹

## Troubleshooting

### Build fails with "Android SDK not found"
- Set the `local.properties` file with: `sdk.dir=/path/to/your/android-sdk`
- Or set the environment variable: `export ANDROID_SDK_ROOT=/path/to/android-sdk`

### APK installation fails
- Ensure your device allows installation from unknown sources:
  - Settings > Security > Unknown Sources (enable)
- Use a compatible Android version (5.0 or higher)

### App crashes on old devices
- Ensure your device is running Android 5.0 (API 21) or higher

## License

This project is provided as-is for educational and personal use.

## References

- Rockport Company Walking Test: https://en.wikipedia.org/wiki/Rockport_fitness_test
- Android Development Documentation: https://developer.android.com/
