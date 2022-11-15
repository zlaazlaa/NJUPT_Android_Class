package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.button.MaterialButton

class NotifyMe : AppCompatActivity() {
    private val cHANNEL_ID = 1278682422.toString()
    private val notifyId = 1234
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_me)
        createNotificationChannel()
        val builder = NotificationCompat.Builder(this, cHANNEL_ID)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("顶部通知")
            .setContentText("这是一个通知，这是一个通知，这是一个通知，这是一个通知")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("这是一个通知，这是一个通知，这是一个通知，这是一个通知")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val bt1 = findViewById<MaterialButton>(R.id.bt1)
        val bt2 = findViewById<MaterialButton>(R.id.bt2)
        val bt3 = findViewById<MaterialButton>(R.id.bt3)
        bt2.isEnabled = false
        bt3.isEnabled = false
        bt1.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                notify(notifyId, builder.build())
            }
            bt1.isEnabled = false
            bt2.isEnabled = true
            bt3.isEnabled = true
        }

        bt2.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                // notificationId is a unique int for each notification that you must define
                builder.setContentTitle("这是新通知")
                builder.setContentText("内容已更新，内容已更新，内容已更新，内容已更新，内容已更新")
                notify(notifyId, builder.build())
            }
            bt1.isEnabled = false
            bt2.isEnabled = false
            bt3.isEnabled = true
        }

        bt3.setOnClickListener {
            with(NotificationManagerCompat.from(this)) {
                cancel(notifyId)
            }
            bt1.isEnabled = true
            bt2.isEnabled = false
            bt3.isEnabled = false
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