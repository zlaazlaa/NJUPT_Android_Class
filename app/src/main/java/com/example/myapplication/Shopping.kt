package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class Shopping : AppCompatActivity() {
    private val itemList = ArrayList<Item>()
    lateinit var myActivityLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        if (savedInstanceState == null) { // 初次运行
            initList()
        } else { // 恢复数据
            for (i in 0..19) {
                var key = "String$i"
                val name = savedInstanceState.getString(key)
                key = "Int$i"
                val id = savedInstanceState.getString(key)?.toInt()
                if (id != null && name != null) {
                    itemList.add(Item(name, id))
                }
            }
        }
        findViewById<MaterialButton>(R.id.btn).setOnClickListener {
            val txt = findViewById<EditText>(R.id.edit_text).text.toString()
            val uri = Uri.parse(txt)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setClassName(
                "com.android.chrome",
                "com.google.android.apps.chrome.Main"
            )
            startActivity(intent)
        }
        val layoutManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_shopping)
        val adapter = ShoppingAdapter(itemList, this)
        myActivityLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == Activity.RESULT_OK) {
                    val txt = activityResult.data?.getStringExtra("message").toString()
                    val number = activityResult.data?.getIntExtra("id", 0)  //选择的item
                    val no = activityResult.data?.getIntExtra("No", 0)  //将要放置到No
                    if (number != null) {
                        if (no != null) {
                            adapter.freshItem(txt, number, no)
                        }
                    }
                }
            }
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        for (i in 0..19) {
            var key = "String$i"
            outState.putString(key, itemList[i].name)
            key = "Int$i"
            outState.putString(key, itemList[i].imageId.toString())
            Log.e("KKK", "KKK")
        }
    }

    @SuppressLint("ResourceType")
    fun initList() {
        repeat(20) {
            itemList.add(Item("请选择商品", 0))
        }
    }

}