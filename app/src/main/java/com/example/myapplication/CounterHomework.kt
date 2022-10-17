package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class CounterHomework : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_homework)

        if (savedInstanceState != null) {
            val str = savedInstanceState.getString("count")
            val str2 = savedInstanceState.getString("text")
            findViewById<TextView>(R.id.textView).text = str
            findViewById<TextView>(R.id.edittext).text = str2
        }

        findViewById<MaterialButton>(R.id.btn_count).setOnClickListener {
            val now = findViewById<TextView>(R.id.textView).text.toString()
            var new = now.toInt()
            new++
            findViewById<TextView>(R.id.textView).text = new.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count", findViewById<TextView>(R.id.textView).text.toString())
        outState.putString("text", findViewById<EditText>(R.id.edittext).text.toString())
    }
}