package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        val message = intent.getStringExtra("message")
        var sum = 81.97
        if ((message != null) && (message[0] == '0')) {
            findViewById<LinearLayout>(R.id.linearLayout1).visibility = View.GONE
            sum -= findViewById<TextView>(R.id.price1).text.toString().substring(2, 7).toFloat()
            Log.e("QQ", findViewById<TextView>(R.id.price1).text.toString().substring(2, 6))
        }
        if ((message != null) && (message[1] == '0')) {
            findViewById<LinearLayout>(R.id.linearLayout2).visibility = View.GONE
            sum -= findViewById<TextView>(R.id.price2).text.toString().substring(2, 7).toFloat()
        }
        if ((message != null) && (message[2] == '0')) {
            findViewById<LinearLayout>(R.id.linearLayout3).visibility = View.GONE
            sum -= findViewById<TextView>(R.id.price3).text.toString().substring(2, 7).toFloat()
        }
        findViewById<TextView>(R.id.sum_price).text = String.format("%.2f", sum)
    }
}