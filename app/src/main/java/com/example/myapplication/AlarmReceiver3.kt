package com.example.myapplication

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver3 : BroadcastReceiver() {
    private val cHANNEL_ID = "1135532355"

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(p0: Context?, p1: Intent?) {
//        Toast.makeText(p0, "time to go", Toast.LENGTH_LONG).show()
        Log.e("alarm", "yes")
        if (p0 != null) {
            deliverAlarm(p0)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun deliverAlarm(context: Context) {
        Toast.makeText(context, "time to go!", Toast.LENGTH_LONG).show()
        val notifyId = 1237780
        Log.e("alarm", "11114")
        val contentIntent = Intent(context, Alarm::class.java)
        val contentPendingIntent = PendingIntent.getActivity(
            context, notifyId, contentIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val stopIntent = Intent(context, AlarmReceiver2::class.java)
        stopIntent.action = "com.stop.intent"
        stopIntent.putExtra("id", notifyId)
        val stopPendingIntent =
            PendingIntent.getBroadcast(context, 124551, stopIntent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(context, cHANNEL_ID)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("时间到啦！")
            .setContentText("到点啦！到点啦！")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(R.drawable.shut, "关闭闹钟", stopPendingIntent)
        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(notifyId, builder.build())
        }//
    }
}