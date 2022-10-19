package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication.databinding.ActivityDroidCafeBinding
import com.google.android.material.snackbar.Snackbar


class DroidCafe : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDroidCafeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDroidCafeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_droid_cafe)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "选择成功，正在跳转...", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val intent = Intent(this, OrderActivity::class.java)
            var a = "0"
            var b = "0"
            var c = "0"
            if (findViewById<CheckBox>(R.id.checkbox1).isChecked) a = "1"
            if (findViewById<CheckBox>(R.id.checkbox2).isChecked) b = "1"
            if (findViewById<CheckBox>(R.id.checkbox3).isChecked) c = "1"
            intent.putExtra("message", a + b + c)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_droid_cafe)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

}