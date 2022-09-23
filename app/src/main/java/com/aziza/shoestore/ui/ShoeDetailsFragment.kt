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
import com.aziza.shoestore.databinding.FragmentShoeDetailsBinding
import com.aziza.shoestore.model.Shoe

/**
 * by Aziza Helmy
 */

class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoeDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancleBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.saveBtn.setOnClickListener {

            val name = binding.nameEt.text.toString()
            val company = binding.copmanyEt.text.toString()
            val size = Integer.parseInt(binding.sizeEt.text.toString())
            val description = binding.descEt.text.toString()
            viewModel.validateData(name, company, size, description)
            val newShoe = Shoe(name, size, company, description)
            viewModel.addShoe(newShoe)
            findNavController().navigate(R.id.shoeListFragment)
        }
    }
}