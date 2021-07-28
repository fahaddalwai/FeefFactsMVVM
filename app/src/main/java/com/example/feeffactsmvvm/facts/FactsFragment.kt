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

    private lateinit var binding: FragmentFactsBinding

    private lateinit var viewModel: FactsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_facts, container, false)



        viewModel =
            ViewModelProvider(this).get(FactsViewModel::class.java)      //define instance of viewmodel using provider


        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.factsViewModel = viewModel

        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner




        viewModel.eventFactsFinish.observe(
            viewLifecycleOwner,
            {                   //all event observers stay in ui controller
                if (it) {
                    nextFragment()
                    viewModel.setEventFactsFinishToFalse()
                }

            })


        return binding.root
    }


    private fun nextFragment() {
        findNavController().navigate(R.id.action_factsFragment_to_startFragment)         //all actions,navigation's are defined in ui controller
    }


}