package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class StopAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.getStringExtra("message") == "1") {
            cancelAlarm()
        }
    }
    private fun cancelAlarm() {
        Toast.makeText(this, "Stop", Toast.LENGTH_LONG).show()
    }
}