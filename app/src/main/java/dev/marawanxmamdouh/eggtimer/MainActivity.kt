package dev.marawanxmamdouh.eggtimer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.marawanxmamdouh.eggtimer.ui.EggTimerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, EggTimerFragment.newInstance())
                .commitNow()
        }
    }
}