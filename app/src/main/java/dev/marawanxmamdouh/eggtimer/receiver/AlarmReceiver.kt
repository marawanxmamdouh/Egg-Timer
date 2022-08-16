package dev.marawanxmamdouh.eggtimer.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import dev.marawanxmamdouh.eggtimer.R

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, context.getText(R.string.eggs_ready), Toast.LENGTH_SHORT).show()
    }
}