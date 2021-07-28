package com.example.feeffactsmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.feeffactsmvvm.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)

        binding.start.setOnClickListener {
            goToFactsFragment()
        }






        return binding.root
    }

    private fun goToFactsFragment() {
        findNavController().navigate(R.id.action_startFragment_to_factsFragment)
    }


}