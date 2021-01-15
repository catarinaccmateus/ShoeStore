package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.viewmodel.SharedViewModel


class ShoeListFragment: Fragment() {
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val binding: FragmentShoesListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoes_list,
            container,
            false
        )
        binding.floatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetail))
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { newScore ->
            newScore.forEach {

                val content = "Shoe Name :${it.name}" +
                        "\nSize : ${it.size.toString()}" +
                        "\nCompany : ${it.company} " +
                        "\nDescription : ${it.description} " +
                        "\n"

                val itemBinding: ShoeItemLayoutBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.shoe_item_layout,
                    binding.shoeListView,
                    false
                )
                itemBinding.shoeDetails = content
                itemBinding.shoeName = it.name
                val shoeView = itemBinding.root

                binding.shoeListView.addView(shoeView)
            }

        })
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
        viewModel.logOut()
            view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}