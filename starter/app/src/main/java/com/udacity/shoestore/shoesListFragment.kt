package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class shoesList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val binding: FragmentShoesListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        binding.shoeListTitle.text = viewModel.loggedin.value.toString()
        return binding.root
    }

}