package com.example.feeffactsmvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.feeffactsmvvm.databinding.FragmentFactsBinding


class FactsFragment : Fragment() {

lateinit var binding:FragmentFactsBinding
    var facts=mutableListOf<String>(
        "Lewis Hamilton has won 7 championships!",
        "Ferrari is one of the oldest and most prestigious constructor",
        "Each car is made up of more than 80000 separate components",
        "An F1 car can go from 0-100mph and back down to 0 in as little as 4 seconds.",
        "Brakes in an F1 car can reach 1000*C and still work fine",
        "Max Verstappen is the youngest race winner at the age of 18",
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_facts, container, false)

        nextFact()




        binding.NextFactButton.setOnClickListener{ nextFact() }



        return binding.root
    }

    fun nextFact(){
        facts.shuffle()
        binding.factsTextView.text=facts[0]
        facts.removeAt(0)
    }


}