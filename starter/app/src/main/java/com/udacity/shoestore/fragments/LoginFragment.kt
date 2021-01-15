package com.udacity.shoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.viewmodel.SharedViewModel

class LoginFragment : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.signupButton.setOnClickListener {view: View? ->
            logIn()
        }
        binding.loginButton.setOnClickListener {view: View? ->
            logIn()
        }

        binding.emailInput.addTextChangedListener {
           shouldButtonsBeDisabled()
        }

        binding.passwordInput.addTextChangedListener{
            shouldButtonsBeDisabled()
        }

        return binding.root
    }

    private fun shouldButtonsBeDisabled() {
        if (binding.emailInput.text.isNotEmpty() && binding.passwordInput.text.isNotEmpty()) {
            binding.apply {
                loginButton.isEnabled = true
                signupButton.isEnabled = true
            }
        } else {
            binding.apply {
                loginButton.isEnabled = false
                signupButton.isEnabled = false
            }
        }
    }

    private fun navigateToWelcomePage(view: View?) {
        view?.findNavController()?.navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    private fun logIn() {
        viewModel.logIn()
        navigateToWelcomePage(view)
    }


}