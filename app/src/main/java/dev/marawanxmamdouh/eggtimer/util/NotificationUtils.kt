package dev.marawanxmamdouh.eggtimer.util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import dev.marawanxmamdouh.eggtimer.MainActivity
import dev.marawanxmamdouh.eggtimer.R

private const val NOTIFICATION_ID = 0
private const val REQUEST_CODE = 0
private const val FLAGS = 0

// TODO: Step 1.1 extension function to send messages (GIVEN)
/**
 * Builds and delivers the notification.
 *
 * @param applicationContext, activity context.
 */
@RequiresApi(Build.VERSION_CODES.M)
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {

    // Create the content intent for the notification, which launches this activity
    val contentIntent = Intent(applicationContext, MainActivity::class.java)

    val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    // TODO: Step 2.0 add style

    // TODO: Step 2.2 add snooze action

    /**
     * Build the notification
     * Step 1.2 get an instance of NotificationCompat.Builder
     * Step 1.3 set title, text and icon to builder
     * Step 1.4 call notify
     */
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.egg_notification_channel_id)
    ).setSmallIcon(R.drawable.cooked_egg)
        .setContentTitle(applicationContext.getString(R.string.notification_title))
        .setContentText(messageBody)
        .setContentIntent(contentPendingIntent)
        .setAutoCancel(true)

    notify(NOTIFICATION_ID, builder.build())

    // TODO: Step 1.13 set content intent

    // TODO: Step 2.1 add style to builder

    // TODO: Step 2.3 add snooze action

    // TODO: Step 2.5 set priority

}

fun NotificationManager.cancelNotifications() {
    cancelAll()
}
