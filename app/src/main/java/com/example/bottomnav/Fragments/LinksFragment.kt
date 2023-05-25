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
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.bottomnav.R
import com.example.bottomnav.SharedViewModel

class LinksFragment : Fragment() {
    private lateinit var editText: Editable
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_links, container, false)

        editText = view.findViewById<EditText>(R.id.editText).text

        view.findViewById<Button>(R.id.send).setOnClickListener{
            sharedViewModel.data.value = editText.toString()
            Log.d("lund", editText.toString())
        }
        return view
    }

}