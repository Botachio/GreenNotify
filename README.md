# GreenNotify - Option 2 - Free APK Build
Generated from Spec v1.0 - Bangkok Metro 33 Courses, 594 Greens

## How to build APK FREE:
1. Create GitHub repo `greennotify`
2. Upload this folder
3. Actions tab -> Build APK runs automatically
4. Download artifact GreenNotify.apk
5. Install on Android

## Core logic implemented:
- GeofenceManager: Tee 120m + Green 45m, dwell 3s, hardware low power
- ShotDetector: accelerometer >2.5g
- YardageEngine: Haversine + point-in-polygon, shouldNotify only if moved >15m + still 3s
- Notification: vibration 200,100,200, high importance

## Files:
- app/src/main/java/com/greennotify/...
- app/src/main/assets/bangkok_greens.geojson
