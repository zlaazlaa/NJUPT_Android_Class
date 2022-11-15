package com.example.myapplication

import android.app.AlarmManager
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService


class AlarmReceiver2 : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        val id = p1?.getIntExtra("id", 0)
        val manager = p0?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        if (manager != null) {
            if (id != null) {
                manager.cancel(id)
                Toast.makeText(p0, "闹钟已关闭", Toast.LENGTH_LONG).show()
            }
        }
    }
}