package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<MaterialButton>(R.id.btn).setOnClickListener {
            val txt = findViewById<EditText>(R.id.editText).text.toString()
            val intent2 = Intent(this, FirstActivity::class.java)
            intent2.putExtra("message", txt)
            startActivity(intent2)
            overridePendingTransition(R.anim.in_from_left, R.anim.out_from_right)
        }
    }

    override fun onStart() {
        super.onStart()
        val message = intent.getStringExtra("message")
        findViewById<TextView>(R.id.show_text).text = message
    }
}