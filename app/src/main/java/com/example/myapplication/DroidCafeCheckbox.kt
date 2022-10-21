package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast

class DroidCafeCheckbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_droid_cafe_checkbox)
        val cc = CheckedChange(this)
        findViewById<CheckBox>(R.id.checkbox1).setOnCheckedChangeListener(cc)
        findViewById<CheckBox>(R.id.checkbox2).setOnCheckedChangeListener(cc)
        findViewById<CheckBox>(R.id.checkbox3).setOnCheckedChangeListener(cc)
        findViewById<CheckBox>(R.id.checkbox4).setOnCheckedChangeListener(cc)
        findViewById<CheckBox>(R.id.checkbox5).setOnCheckedChangeListener(cc)
        findViewById<CheckBox>(R.id.checkbox6).setOnCheckedChangeListener(cc)
    }

    inner class CheckedChange(droidCafeCheckbox: DroidCafeCheckbox) :
        CompoundButton.OnCheckedChangeListener {
        private val dcc = droidCafeCheckbox
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            if (p0?.isChecked == true)
                Toast.makeText(dcc, p0.text.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemOrder2 -> {
                val intent = Intent(this, DroidCafe::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}