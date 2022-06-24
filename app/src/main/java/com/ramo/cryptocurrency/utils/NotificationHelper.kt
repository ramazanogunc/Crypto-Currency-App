package com.ramo.cryptocurrency.utils

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import com.ramo.cryptocurrency.R
import com.ramo.cryptocurrency.ui.MainActivity

private const val CHANNEL_ID = "coin"

object NotificationHelper {

    fun sendNotification(context: Context, message: String) {
        val title = context.getString(R.string.app_name)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)


        val notificationChannel: NotificationChannel
        val builder: Notification.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel =
                NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.GREEN
            notificationChannel.enableVibration(false)
            notificationManager.createNotificationChannel(notificationChannel)

            builder = Notification.Builder(context, CHANNEL_ID)
                .setContentText(title)
                .setContentText(message)
                .setSmallIcon(R.drawable.ic_notification)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        context.resources,
                        R.drawable.ic_notification
                    )
                )
                .setContentIntent(pendingIntent)
        } else {
            builder = Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentText(title)
                .setContentText(message)
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        context.resources,
                        R.drawable.ic_notification
                    )
                )
                .setContentIntent(pendingIntent)
        }
        notificationManager.notify(1, builder.build())
    }
}