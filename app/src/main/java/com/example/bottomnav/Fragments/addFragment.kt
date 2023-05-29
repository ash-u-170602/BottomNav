package com.example.bottomnav.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnav.R
import com.example.bottomnav.databinding.FragmentAddBinding

class addFragment : Fragment() {
    private val binding by lazy { FragmentAddBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_add, container, false)
        return binding.root
    }

}