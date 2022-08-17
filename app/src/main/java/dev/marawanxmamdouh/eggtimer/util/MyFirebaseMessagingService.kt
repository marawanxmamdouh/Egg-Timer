package dev.marawanxmamdouh.eggtimer.util

import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val TAG = "MyFirebaseMsgService"

class MyFirebaseMessagingService : FirebaseMessagingService() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(TAG, "From: ${remoteMessage.from}") // From: /topics/breakfast

        // Check if message contains a data payload.
        remoteMessage.data.let {
            Log.i(TAG, "Message data payload: " + remoteMessage.data) // Message data payload: {egg=3}
        }

        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")
            sendNotification(it.body!!)
        }
    }

    override fun onNewToken(token: String) {
        Log.i("TAG", "Refreshed token: $token")
        super.onNewToken(token)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun sendNotification(messageBody: String) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.sendNotification(messageBody, applicationContext)
    }
}