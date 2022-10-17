package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View.inflate
import com.google.android.material.button.MaterialButton

class ShowSomeText : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_some_text)
        val btn1 = findViewById<MaterialButton>(R.id.btn1)
        val btn2 = findViewById<MaterialButton>(R.id.btn2)
        val btn3 = findViewById<MaterialButton>(R.id.btn3)
        btn1.setOnClickListener {
            start(btn1.text.toString())
        }
        btn2.setOnClickListener {
            start(btn2.text.toString())
        }
        btn3.setOnClickListener {
            start(btn3.text.toString())
        }
    }

    private fun start(txt: String) {
        val intent = Intent(this, ScrollingText::class.java)
        intent.putExtra("message", txt)
        startActivity(intent)
    }
}