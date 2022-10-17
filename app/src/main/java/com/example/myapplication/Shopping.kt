package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.button.MaterialButton

class Shopping : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val myActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == Activity.RESULT_OK) {
                    val txt = activityResult.data?.getStringExtra("message")
                    val number = activityResult.data?.getStringExtra("id")
                    Log.e("TEST", txt + number)
                }
            }
        findViewById<MaterialButton>(R.id.btn11111).setOnClickListener {
            val txt = findViewById<MaterialButton>(R.id.btn11111).text.toString()
            val intent = Intent(this, SelectItem::class.java).apply {
                putExtra("message", txt[txt.length - 1])
            }
            myActivityLauncher.launch(intent)
        }

    }


    fun onClick(btn: MaterialButton) {
        val txt = btn.text.toString()
        val intent = Intent(this, SelectItem::class.java).apply {
            putExtra("message", txt[txt.length - 1])
        }
    }
}