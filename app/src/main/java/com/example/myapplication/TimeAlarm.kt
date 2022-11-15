package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton


class TimeAlarm : AppCompatActivity() {
    private val cHANNEL_ID = "113355"
    private val notifyId = 125127

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_alarm)
        createNotificationChannel()
        findViewById<TimePicker>(R.id.time_picker).setIs24HourView(true)
        findViewById<MaterialButton>(R.id.btn_start).setOnClickListener {
            val timePicker = findViewById<TimePicker>(R.id.time_picker)
            val hour = timePicker.hour
            val minute = timePicker.minute
            val calender = Calendar.getInstance()
            calender.set(Calendar.HOUR_OF_DAY, hour)
            calender.set(Calendar.MINUTE, minute)
            calender.set(Calendar.SECOND, 5)
            deliverNotification(this, calender)
        }
    }

    @SuppressLint("LaunchActivityFromNotification")
    @RequiresApi(Build.VERSION_CODES.N)
    fun deliverNotification(context: Context, calendar: Calendar) {
        val intent = Intent(this, AlarmReceiver3::class.java)
        val pi = PendingIntent.getBroadcast(this, 124762, intent, PendingIntent.FLAG_IMMUTABLE)
        val am = this.getSystemService(ALARM_SERVICE) as AlarmManager
        am.set(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis + 10 * 1000,
            pi
        )
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel"
            val descriptionText = "测试channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(cHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun cancelAlarm() {
        Toast.makeText(this, "清除！", Toast.LENGTH_LONG).show()
        val alarmManager = this.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }
}