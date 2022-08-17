package dev.marawanxmamdouh.eggtimer.util

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val TAG = "MyFirebaseMsgService"

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.i(TAG, "From: ${remoteMessage.from}") // From: /topics/breakfast

        // Check if message contains a data payload.
        remoteMessage.data.let {
            Log.i(TAG, "Message data payload: " + remoteMessage.data) // Message data payload: {egg=3}
        }
        super.onMessageReceived(remoteMessage)
    }

    override fun onNewToken(token: String) {
        Log.i("TAG", "Refreshed token: $token")
        super.onNewToken(token)
    }
}