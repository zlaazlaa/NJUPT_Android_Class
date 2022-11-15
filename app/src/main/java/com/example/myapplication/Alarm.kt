package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import android.widget.ToggleButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat


class Alarm : AppCompatActivity() {
    private val cHANNEL_ID = "1135532355"
    private val notifyId = 125127

    @SuppressLint("UnspecifiedImmutableFlag")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        createNotificationChannel()


        val notifyIntent = Intent("com.broad.intent")
        notifyIntent.setClass(this, Class.forName("com.example.myapplication.AlarmReceiver"))
        val notifyPendingIntent =
            PendingIntent.getBroadcast(this, notifyId, notifyIntent, PendingIntent.FLAG_IMMUTABLE)
        val toggle = findViewById<ToggleButton>(R.id.toggle_botton)




        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager


        toggle.setOnClickListener {
            if (toggle.isChecked) {
                Toast.makeText(this, "开始久坐计时！",Toast.LENGTH_LONG).show()
                val repeatInterval = 100L
                val triggerTime = (SystemClock.elapsedRealtime()
                        + repeatInterval)
                alarmManager.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP,
                    triggerTime,
                    repeatInterval,
                    notifyPendingIntent
                )
            } else {
                Toast.makeText(this, "取消计时！",Toast.LENGTH_LONG).show()
                with(NotificationManagerCompat.from(this)) {
                    // notificationId is a unique int for each notification that you must define
                    cancelAll()
                    alarmManager.cancel(notifyPendingIntent)
                }
            }
        }
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel"
            val descriptionText = "测试channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(cHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


}