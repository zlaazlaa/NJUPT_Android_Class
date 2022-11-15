package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewTest : AppCompatActivity() {
    val wordList = ArrayList<Word>()
    val adapter = WordAdapter(wordList)

    //    val context = context
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_test)
        init()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        findViewById<View>(R.id.fab).setOnClickListener {
            wordList.clear()
            init()
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "刷新成功", Toast.LENGTH_SHORT).show()
        }

        findViewById<View>(R.id.fab2).setOnClickListener {
            val dia = DialogFragment(this)
            dia.show(supportFragmentManager, "aaaa")
        }
    }

    private fun init() {
        repeat(1) {
            wordList.add(Word("apple"))
            wordList.add(Word("pear"))
            wordList.add(Word("banana"))
            wordList.add(Word("mango"))
            wordList.add(Word("peach"))
            wordList.add(Word("cherries"))
        }
    }
}