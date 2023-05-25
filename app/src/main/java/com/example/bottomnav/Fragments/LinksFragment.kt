package com.example.bottomnav.Fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.bottomnav.R
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentLinksBinding

class LinksFragment : Fragment() {
    private lateinit var editText: EditText
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val binding by lazy { FragmentLinksBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.send.setOnClickListener{
            sharedViewModel.getHomeData(binding.editText.text.toString())
        }
    }

}