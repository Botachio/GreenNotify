package com.greennotify.engine
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import kotlin.math.sqrt

class ShotDetector(private val onShot: () -> Unit) : SensorEventListener {
    private var lastShotTime = 0L
    override fun onSensorChanged(e: SensorEvent?) {
        if (e?.sensor?.type != Sensor.TYPE_ACCELEROMETER) return
        val mag = sqrt(e.values[0]*e.values[0] + e.values[1]*e.values[1] + e.values[2]*e.values[2])
        val now = System.currentTimeMillis()
        if (mag > 24.5 && now - lastShotTime > 5000) {
            lastShotTime = now
            onShot()
        }
    }
    override fun onAccuracyChanged(s: Sensor?, a: Int) {}
}
