package com.example.feeffactsmvvm.facts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.feeffactsmvvm.R
import com.example.feeffactsmvvm.databinding.FragmentFactsBinding




class FactsFragment : Fragment() {

    lateinit var binding: FragmentFactsBinding

    private lateinit var viewModel:FactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_facts, container, false)



        viewModel = ViewModelProvider(this).get(FactsViewModel::class.java)

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.factsViewModel = viewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.eventFactsFinish.observe(viewLifecycleOwner, {
            if(it){
                nextFragment()
                viewModel.setEventGameFinishToFalse()
            }

        })











        return binding.root
    }





    private fun nextFragment() {
        findNavController().navigate(R.id.action_factsFragment_to_startFragment)
    }


}