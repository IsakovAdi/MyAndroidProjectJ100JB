package com.example.fragmentsnavigator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragmentsnavigator.R
import com.example.fragmentsnavigator.databinding.FragmentHelloBinding


class HelloFragment : Fragment() {

    private val binding by lazy {
        FragmentHelloBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.readyButton.setOnClickListener {
            openShooseLevelFragment()
        }
    }

    private fun openShooseLevelFragment() {
        findNavController().navigate(
            HelloFragmentDirections.actionHelloFragmentToChooseLevelFragment()
        )
    }

}