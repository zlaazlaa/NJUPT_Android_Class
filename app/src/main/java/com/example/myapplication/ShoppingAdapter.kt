package com.example.myapplication

import android.R.drawable
import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton


class ShoppingAdapter(
    private var itemList: ArrayList<Item>,
    private val shopping: Shopping
) :
    RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemName: TextView = view.findViewById(R.id.item_name)
        val itemBtn: MaterialButton = view.findViewById(R.id.item_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceType", "UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        Log.e("ID", "${item.imageId}")
        val idTemp = item.imageId - 1
        val idName = "a" +
                if (idTemp != -1) (idTemp % 13 + 1).toString() else "0"

        val id: Int =
            shopping.resources.getIdentifier(idName, "drawable", "com.example.myapplication")
        holder.itemImage.setImageResource(id)
        holder.itemName.text = item.name
        holder.itemBtn.text = "去选择商品"
        holder.itemBtn.setOnClickListener {
            val intent = Intent(shopping, SelectItem::class.java)
            intent.putExtra("No", position)
            shopping.myActivityLauncher.launch(intent)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun freshItem(txt: String, id: Int, position: Int) {
        Log.e("OK", "ko")
        itemList[position] = Item(txt, id)
        Log.e("KK", "ss")
        this.notifyItemChanged(position)
    }


}