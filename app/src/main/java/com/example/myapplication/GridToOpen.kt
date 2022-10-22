package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment

class GridToOpen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_to_open)
        when (intent.getStringExtra("id")?.toInt()) {
            1 -> {
                replaceFragment(GirdFirstFragment())
            }
            3 -> {
                replaceFragment(GridSecondFragment())
            }
            2 -> {
                replaceFragment(GridThirdFragment())
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemBack -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}