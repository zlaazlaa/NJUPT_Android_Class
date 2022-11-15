package com.example.myapplication

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.math.log


class AlarmReceiver : BroadcastReceiver() {
    private val cHANNEL_ID = "1135532355"
    private val notifyId = 125127
    lateinit var mNotificationManager: Any

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context, intent: Intent) {
        Log.e("alarm", "${intent.action}")
        mNotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)
        deliverNotification(context)
        Log.e("alarm", "21324")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("UnspecifiedImmutableFlag")
    fun deliverNotification(context: Context) {
        Log.e("alarm", "12324")
        val contentIntent = Intent(context, Alarm::class.java)
        val contentPendingIntent = PendingIntent.getActivity(
            context, notifyId, contentIntent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val builder = NotificationCompat.Builder(context, cHANNEL_ID)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("久坐通知")
            .setContentText("正在计时")
//            .setContentIntent(contentPendingIntent)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("正在计时")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .addAction(R.drawable.shut, "关闭闹钟", contentPendingIntent)
        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(notifyId, builder.build())
        }
    }

}