package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodel.SharedViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel: SharedViewModel by activityViewModels()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
        binding.cancelDetailsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetail_to_shoeListFragment))
        binding.detailsSaveButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetail_to_shoeListFragment))
        return binding.root
    }

}

/*
        Previous implementation (before two way data binding):

        binding.detailsSaveButton.setOnClickListener {
            val name = binding.detailsShoeName.text.toString()
            val company = binding.detailsShoeCompany.text.toString()
            val description = binding.detailsShoeDescription.text.toString()
            val size: Double = binding.detailsShoeSize.text.toString().toDoubleOrNull() ?: 0.0
            val shoe = Shoe(name, size, company, description)
            viewModel.addShoe(shoe)
            view?.findNavController()?.navigate(R.id.action_shoeDetail_to_shoeListFragment)
        }
 */