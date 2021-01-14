package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
       // viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        binding.signupButton.setOnClickListener {view: View? ->
            logIn()
        }
        binding.loginButton.setOnClickListener {view: View? ->
            logIn()
        }
        return binding.root
    }

    private fun navigateToWelcomePage(view: View?) {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    private fun logIn() {
        viewModel.logIn()
        navigateToWelcomePage(view)
    }


}