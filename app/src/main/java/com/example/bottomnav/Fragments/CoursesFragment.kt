package com.example.bottomnav.Fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bottomnav.SharedViewModel
import com.example.bottomnav.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val binding by lazy { FragmentCoursesBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.country.observe(requireActivity()) { data ->
            binding.textView.text = data
        }
    }

}