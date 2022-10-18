package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SelectItem : AppCompatActivity() {

    private val itemList = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_item)
        initItem()
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val no = intent.getIntExtra("No", 0)
        val adapter = ItemAdapter(itemList, this, no)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun initItem() {
        repeat(3) {
            itemList.add(Item("签字笔", R.drawable.a1))
            itemList.add(Item("支付宝", R.drawable.a2))
            itemList.add(Item("A本", R.drawable.a3))
            itemList.add(Item("U型管", R.drawable.a4))
            itemList.add(Item("衬衫", R.drawable.a5))
            itemList.add(Item("照相机", R.drawable.a6))
            itemList.add(Item("烧瓶", R.drawable.a7))
            itemList.add(Item("锤子", R.drawable.a8))
            itemList.add(Item("钟表", R.drawable.a9))
            itemList.add(Item("表格", R.drawable.a10))
            itemList.add(Item("上下", R.drawable.a11))
            itemList.add(Item("转弯", R.drawable.a12))
            itemList.add(Item("搜索", R.drawable.a13))
        }
    }

}