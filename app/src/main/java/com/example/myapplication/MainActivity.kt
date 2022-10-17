package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent()
        var message = intent.getStringExtra("message")
        if (message == null) {
            message = "0"
        }
        findViewById<TextView>(R.id.textView).text = message
        findViewById<MaterialButton>(R.id.button).setOnClickListener {
            val now = findViewById<TextView>(R.id.textView).text.toString()
            var new = now.toInt()
            new++
            findViewById<TextView>(R.id.textView).text = new.toString()
        }

        findViewById<MaterialButton>(R.id.button2).setOnClickListener {
            val toast = Toast.makeText(this, "666", Toast.LENGTH_LONG)
            toast.show()
            val intent22 = Intent(this, ShowHelloToast::class.java)
            intent22.putExtra("message" ,findViewById<TextView>(R.id.textView).text.toString())
            startActivity(intent22)
        }

        findViewById<MaterialButton>(R.id.button3).setOnClickListener {
            findViewById<TextView>(R.id.textView).text = "0"
        }
    }
}