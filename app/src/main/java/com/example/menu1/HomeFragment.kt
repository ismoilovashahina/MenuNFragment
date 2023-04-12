package com.example.menu1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.menu1.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =  FragmentHomeBinding.inflate(inflater, container, false)
        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_mainFragment)
        }
        return binding.root
    }
}