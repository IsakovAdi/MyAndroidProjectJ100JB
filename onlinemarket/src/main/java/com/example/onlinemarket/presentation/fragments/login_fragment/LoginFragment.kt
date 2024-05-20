package com.example.onlinemarket.presentation.fragments.login_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onlinemarket.MainActivity
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.FragmentLoginBinding
import com.example.onlinemarket.presentation.RootActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val binding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<LoginFragmentViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkSavedUser()
        binding.loginText.setOnClickListener {
            openRegisterFragment()
        }
        binding.registerBtn.setOnClickListener {
            openRootActivity()
        }
        observe()
    }

    private fun observe() {
        viewModel.user.observe(viewLifecycleOwner) {
            openRootActivity()
        }
    }

    private fun openRegisterFragment() {
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
        )
    }

    private fun openRootActivity() {
        startActivity(Intent(requireContext(), RootActivity::class.java))
        requireActivity().finish()
    }

}