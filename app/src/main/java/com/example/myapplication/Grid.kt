package com.example.myapplication

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class Grid : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        findViewById<LinearLayout>(R.id.img1).setOnClickListener(this)
        findViewById<LinearLayout>(R.id.img2).setOnClickListener(this)
        findViewById<LinearLayout>(R.id.img3).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, GridToOpen::class.java)
        when (p0?.id) {
            R.id.img1 -> {
                intent.putExtra("id", "1")
            }
            R.id.img2 -> {
                intent.putExtra("id", "2")
            }
            R.id.img3 -> {
                intent.putExtra("id", "3")
            }
        }
        val knx = Pair.create(findViewById<View>(R.id.image1), "partOrderOpen_knx")
        val mg = Pair.create(findViewById<View>(R.id.image2), "partOrderOpen_mg")
        val xyc = Pair.create(findViewById<View>(R.id.image3), "partOrderOpen_xyc")
        startActivity(
            intent,
            ActivityOptions.makeSceneTransitionAnimation(this, knx, mg, xyc).toBundle()
        )
    }
}