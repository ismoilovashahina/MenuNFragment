package com.example.menu1

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.menu1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction()
            .replace(R.id.cabinetLayout, CabinetFragment())
            .replace(R.id.orderLayout, OrderFragment())
            .commit()

        binding.cabinetLayout.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_cabinetFragment)
        }

        binding.orderLayout.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_orderFragment)
        }


        val activity : AppCompatActivity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbar)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1->{
                findNavController().navigate(R.id.action_mainFragment_to_cabinetFragment)
            }
            R.id.item2 -> {
                findNavController().navigate(R.id.action_mainFragment_to_orderFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}