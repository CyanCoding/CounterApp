package com.example.testapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.testapp.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Binding for subtract button
        binding.subtractButton.setOnClickListener {
            countMe(true, view)
        }

        // Binding for add button
        binding.addButton.setOnClickListener {
            countMe(false, view)
        }

        // Binding for random fragment button
        binding.randomFragmentButton.setOnClickListener {
            val count = view.findViewById<TextView>(R.id.textview_first).text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(count)
            findNavController().navigate(action)

        }
    }

    private fun countMe(subtract: Boolean, view: View) {
        val textView = view.findViewById<TextView>(R.id.textview_first)
        var count = textView.text.toString().toInt()

        if (subtract) {
            count--
        }
        else {
            count++
        }

        textView.text = count.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}