package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class ItemAdapter(
    private val itemList: List<Item>,
    private val selectItem: SelectItem,
    private val No: Int
) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemName: TextView = view.findViewById(R.id.item_name)
        val itemBtn: MaterialButton = view.findViewById(R.id.item_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(item.imageId)
        holder.itemName.text = item.name
        holder.itemBtn.text = "选择这个商品"
        holder.itemBtn.setOnClickListener {
            val id = position
            val item2 = itemList[id]
            val txt = item2.name
            val intent = Intent().apply {
                putExtra("message", txt)
                putExtra("id", position + 1)
                putExtra("No", No)
            }
            selectItem.setResult(Activity.RESULT_OK, intent)
            selectItem.finish()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}