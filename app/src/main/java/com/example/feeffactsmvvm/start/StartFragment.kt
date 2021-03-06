package com.example.feeffactsmvvm.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feeffactsmvvm.R
import com.example.feeffactsmvvm.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var viewModel:StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        binding.start.setOnClickListener{ nextFragment() }           //Here we have a onclicklistener because it is for an action



        return binding.root
    }

    private fun nextFragment() {
        findNavController().navigate(R.id.action_startFragment_to_factsFragment)
    }


}