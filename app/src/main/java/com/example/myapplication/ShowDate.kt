package com.example.myapplication

import DatePickerFragment
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.google.android.material.button.MaterialButton
import org.w3c.dom.Text
import java.util.*

class ShowDate : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_data)
        findViewById<MaterialButton>(R.id.selectData).setOnClickListener {
//            val pickerListener =
//                object : DatePickerDialog.OnDateSetListener {
//                    @SuppressLint("SetTextI18n")
//                    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
//                        findViewById<TextView>(R.id.textView).text =
//                            "$p1-$p2-$p3"
//                    }
//
//                }
//            val picker = DatePickerDialog(this, pickerListener, 2022, 10, 21)
//            picker.show()
            val pickTime = TimePickerDialog.OnTimeSetListener { p0, p1, p2 ->
                findViewById<TextView>(R.id.textView).text =
                    "$p1" + "点" + "$p2" + "分"
            }
            val picker = TimePickerDialog(this, pickTime, 22, 14, true)
            picker.show()
        }
    }
}