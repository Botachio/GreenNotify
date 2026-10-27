package com.greennotify.engine
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

object NotificationHelper {
    const val CHANNEL_YARDAGE = "yardage_channel"
    fun notifyYardage(ctx: Context, hole: Int, center: Int, front: Int, back: Int, wind: String) {
        val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= 26) {
            val ch = NotificationChannel(CHANNEL_YARDAGE, "Yardage", NotificationManager.IMPORTANCE_HIGH)
            ch.vibrationPattern = longArrayOf(200,100,200)
            nm.createNotificationChannel(ch)
        }
        val notif = NotificationCompat.Builder(ctx, CHANNEL_YARDAGE)
            .setContentTitle("Hole $hole Par 4 - $center y to Green")
            .setContentText("Center $center y | Front $front y | Back $back y | Wind $wind")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setVibrate(longArrayOf(200,100,200))
            .setPriority(NotificationCompat.PRIORITY_HIGH).build()
        nm.notify(hole, notif)
    }
}
