package com.example.bottomnav.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentLinksBinding

class LinksFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val binding by lazy { FragmentLinksBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.send.setOnClickListener {
            sharedViewModel.getHomeData(binding.editText.text.toString())
        }
    }

}