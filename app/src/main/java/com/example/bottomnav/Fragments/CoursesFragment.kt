package com.example.bottomnav.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.bottomnav.R
import com.example.bottomnav.SharedViewModel


class CoursesFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_courses, container, false)
        val textView = view.findViewById<TextView>(R.id.textView)

        sharedViewModel.data.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return view
    }

}