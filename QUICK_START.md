# VO2MAX Calculator - Quick Start Guide

## What is This?

A simple Android app that calculates your **VO2MAX** (maximum oxygen uptake) - a key indicator of cardiovascular fitness - after you walk 2 kilometers.

## Files Included

| File | Purpose |
|------|---------|
| `VO2Max-Installer.apk` | **The Android app installer** - Install this on your phone |
| `VO2MaxApp/` | Complete source code and project files |
| `INSTALLATION_GUIDE.md` | Detailed installation and usage instructions |
| `README.md` | Technical documentation |

## Quick Installation (30 seconds)

1. **Transfer `VO2Max-Installer.apk` to your Android phone**
   - Via email, USB cable, or cloud storage

2. **Tap the APK file** on your phone's file manager
   - Allow installation from unknown sources when prompted
   - Installation completes automatically

3. **Open "VO2MAX Calculator"** from your app drawer

## How to Use (2 minutes)

1. **Walk 2 kilometers** at a comfortable, steady pace
2. **Record your data**:
   - Your gender (Male/Female)
   - Your age
   - Your weight (in kg)
   - Your height (in meters)
   - Your heart rate right after the walk (beats per minute)
   - The time it took (in decimal format: minutes + seconds÷60)

3. **Open the app and enter the data**
4. **Tap "Calculate VO2MAX"**
5. **View your result** in ml•kg⁻¹•min⁻¹

## Example

```
Input:
Gender: Male
Age: 40 years
Weight: 80 kg
Height: 1.75 m
Heart Rate: 135 bpm
Time: 18 minutes 30 seconds (18.5 minutes)

Result:
VO2MAX: 42.15 ml•kg⁻¹•min⁻¹
(Good fitness level)
```

## System Requirements

- **Device:** Any Android smartphone or tablet
- **Android Version:** 5.0 or newer
- **Storage:** ~1 MB free space
- **Special Permissions:** None required

## Fitness Level Reference

**General VO2MAX Scale (ml•kg⁻¹•min⁻¹)**

| Men | Women | Level |
|-----|-------|-------|
| < 25 | < 22 | Poor |
| 25-35 | 22-32 | Fair |
| 35-45 | 32-42 | Average |
| 45-55 | 42-52 | Good |
| 55-65 | 52-60 | Excellent |
| > 65 | > 60 | Superior |

## Important Notes

✓ The app uses the scientifically-validated **Rockport Walking Test formula**  
✓ No internet connection needed  
✓ No ads or tracking  
✓ Your data is only stored locally on your device  
✓ Free to use  

⚠️ Results are estimations; not a medical test  
⚠️ For health concerns, consult a doctor  
⚠️ Ensure your device is on Android 5.0+  

## Building from Source

If you want to rebuild the APK:

```bash
cd VO2MaxApp
export ANDROID_SDK_ROOT=/path/to/android-sdk
gradle assembleDebug
# APK created at: app/build/outputs/apk/debug/app-debug.apk
```

Or use the included `Dockerfile` for automatic building.

## Troubleshooting

| Problem | Solution |
|---------|----------|
| "Unknown app" error | Enable Settings → Security → Unknown Sources |
| App won't open | Restart phone, ensure Android 5.0+ |
| Installation fails | Free up storage space (need ~50MB temporary) |
| Calculation wrong | Double-check all input values |

## Technical Information

- **Language:** Java (Android)
- **SDK Version:** API 21 (Android 5.0)
- **File Size:** 916 KB
- **Architecture:** Universal (ARM, ARM64, x86)
- **No root access required**

## Formula

**Men:** VO2max = 184.9 – 4.65T – 0.22HR – 0.26A – 1.05IMC  
**Women:** VO2max = 116.2 – 2.98T – 0.11HR – 0.14A – 0.39IMC

Variables:
- T = Walking time (minutes, decimal)
- HR = Heart rate (beats per minute)
- A = Age (years)
- IMC = BMI (weight in kg / height in m²)

## Getting Help

1. **Installation issues?** → See `INSTALLATION_GUIDE.md`
2. **How to use?** → See the in-app hints or `INSTALLATION_GUIDE.md`
3. **Source code?** → Check `VO2MaxApp/` folder

## Version Info

- **Version:** 1.0
- **Release Date:** March 8, 2026
- **Status:** Stable Release

---

**Ready to test your fitness? Install the app and find out your VO2MAX!**

For more details, see `INSTALLATION_GUIDE.md` or visit the `README.md` file.
