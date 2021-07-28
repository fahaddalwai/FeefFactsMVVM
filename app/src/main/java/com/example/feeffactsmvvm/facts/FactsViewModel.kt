package com.example.feeffactsmvvm.facts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    private lateinit var factsList: MutableList<String>

    // The current fact
    private val _word = MutableLiveData<String>()                  //encapsulating it
    val word: LiveData<String>
        get() = _word

    // Event action which triggers the end of the all facts and tells whether to go start fragment or not
    private val _eventFactsFinish = MutableLiveData<Boolean>()
    val eventFactsFinish: LiveData<Boolean>
        get() = _eventFactsFinish


    fun setEventFactsFinishToFalse() {
        _eventFactsFinish.value = false
    }

    private fun setEventFactsFinishToTrue() {
        _eventFactsFinish.value = true
    }

    init {
        resetList()
        _eventFactsFinish.value = false

    }

    private fun resetList() {

        factsList = mutableListOf(
            "Lewis Hamilton has won 7 championships!",
            "Ferrari is one of the oldest and most prestigious constructor",
            "Each car is made up of more than 80000 separate components",
            "An F1 car can go from 0-100mph and back down to 0 in as little as 4 seconds.",
            "Brakes in an F1 car can reach 1000*C and still work fine",
            "Max Verstappen is the youngest race winner at the age of 18",
        )

        factsList.shuffle()
        setWord()
    }


    private fun setWord() {
        _word.value = factsList[0]
        removeWord()
    }

    private fun removeWord() {
        factsList.removeAt(0)
    }


    fun checkIfFinishedOrNot() {
        if (factsList.isEmpty()) {
            setEventFactsFinishToTrue()
        } else {
            setWord()
        }
    }

}