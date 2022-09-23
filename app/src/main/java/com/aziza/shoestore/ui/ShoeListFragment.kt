package com.aziza.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.activity.addCallback
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.aziza.shoestore.R
import com.aziza.shoestore.SharedViewModel
import com.aziza.shoestore.databinding.FragmentShoeListBinding
import com.aziza.shoestore.databinding.ItemShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().navigate(R.id.loginFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding = FragmentShoeListBinding.inflate(layoutInflater) //i prefare this "(
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getAllShoe()
        setupMenu()
        binding.addShoeBtn.setOnClickListener {
            findNavController().navigate(R.id.shoeDetailsFragment)
        }
    }

    private fun getAllShoe() {
        viewModel.shoeListResult.observe(viewLifecycleOwner) {
            it.forEach {
                val listBinding = ItemShoeListBinding.inflate(
                    LayoutInflater.from(requireContext()),binding.shoesListLayout, false)
                
                listBinding.apply {
                    tvName.text = it.name
                    tvCompany.text = it.company
                    tvSize.text = it.size.toString()
                    tvDesc.text = it.description
                }
                binding.shoesListLayout.addView(listBinding.root)
            }
        }
    }

    private fun setupMenu() {
        (requireActivity() as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onPrepareMenu(menu: Menu) {
                // Handle for example visibility of menu items
            }

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.logout_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                findNavController().navigate(R.id.loginFragment)
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }
}