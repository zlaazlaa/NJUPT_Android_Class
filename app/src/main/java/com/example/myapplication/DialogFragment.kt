package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.InputEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogFragment(private val recyclerViewTest: RecyclerViewTest) : DialogFragment() {

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val inflater = requireActivity().layoutInflater
            val builder = AlertDialog.Builder(it)

            // Create the AlertDialog object and return it
            val fragmentView = inflater.inflate(R.layout.fragment_dialog, null)
            builder.setView(fragmentView)
            builder.setMessage("单词添加")
                .setPositiveButton("添加",
                    DialogInterface.OnClickListener { dialog, id ->
                        val txt =
                            fragmentView.findViewById<EditText>(R.id.word_to_add).text.toString()
                        if (txt != "") Toast.makeText(
                            activity, "成功添加：$txt！", Toast.LENGTH_SHORT
                        ).show()
                        else Toast.makeText(activity, "输入为空！", Toast.LENGTH_SHORT).show()
                        recyclerViewTest.wordList.add(Word(txt))
                        recyclerViewTest.adapter.notifyItemChanged(recyclerViewTest.wordList.size)
                    })
                .setNegativeButton("取消",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(recyclerViewTest, "取消！", Toast.LENGTH_SHORT).show()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}