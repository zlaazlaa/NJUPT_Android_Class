package com.example.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.imageView.setOnClickListener {
            Toast.makeText(activity, "点击了第一个", Toast.LENGTH_SHORT).show()
        }
        binding.imageView2.setOnClickListener {
            Toast.makeText(activity, "点击了第二个", Toast.LENGTH_SHORT).show()
        }
        binding.imageView3.setOnClickListener {
            Toast.makeText(activity, "点击了第三个", Toast.LENGTH_SHORT).show()
        }
        val gray = Color.rgb(220, 220, 220)
        val white = Color.rgb(255, 255, 255)
        binding.linearLayout1.setOnClickListener {
            binding.linearLayout1.setBackgroundColor(if (!binding.checkbox1.isChecked) gray else white)
            binding.checkbox1.isChecked = !binding.checkbox1.isChecked
        }
        binding.linearLayout2.setOnClickListener {
            binding.linearLayout2.setBackgroundColor(if (!binding.checkbox2.isChecked) gray else white)
            binding.checkbox2.isChecked = !binding.checkbox2.isChecked
        }
        binding.linearLayout3.setOnClickListener {
            binding.linearLayout3.setBackgroundColor(if (!binding.checkbox3.isChecked) gray else white)
            binding.checkbox3.isChecked = !binding.checkbox3.isChecked
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}