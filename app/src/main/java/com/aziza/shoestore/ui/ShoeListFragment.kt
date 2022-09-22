package com.aziza.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.aziza.shoestore.R
import com.aziza.shoestore.SharedViewModel
import com.aziza.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeListBinding.inflate(layoutInflater)
        //binding=DataBindingUtil.setContentView(layoutInflater)//TODO HOW?

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // getAllShoe()

        binding.addShoeBtn.setOnClickListener {
            findNavController().navigate(R.id.shoeDetailsFragment)
        }

    }

    private fun getAllShoe() {
      TODO("Not yet implemented")
    }
}