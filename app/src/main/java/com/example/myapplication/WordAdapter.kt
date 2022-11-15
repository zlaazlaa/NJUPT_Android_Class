package com.example.myapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(private val wordList: List<Word>) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textView)
        val linearLayout: LinearLayout = view.findViewById(R.id.linearLayout)
        val click: TextView = view.findViewById(R.id.click)
        val checkbox: CheckBox = view.findViewById(R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.word_card, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = wordList[position]
        holder.name.text = card.name
        holder.click.text = ""
        holder.checkbox.isChecked = false
        holder.linearLayout.setOnClickListener {
            if (holder.click.text == "") {
                holder.click.text = "Clicked !!"
                holder.checkbox.isChecked = true
            } else {
                holder.click.text = ""
                holder.checkbox.isChecked = false
            }
        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}