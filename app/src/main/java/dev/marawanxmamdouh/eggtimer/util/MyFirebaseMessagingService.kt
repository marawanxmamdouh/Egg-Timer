package dev.marawanxmamdouh.eggtimer.util

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
    }

    override fun onNewToken(token: String) {
        Log.i("TAG", "Refreshed token: $token")
        super.onNewToken(token)
    }
}