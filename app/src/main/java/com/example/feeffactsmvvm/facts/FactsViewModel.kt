package com.example.feeffactsmvvm.facts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FactsViewModel: ViewModel() {

    private lateinit var factsList: MutableList<String>

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get()= _word

    // Event which triggers the end of the game
    private val _eventFactsFinish = MutableLiveData<Boolean>()
    val eventFactsFinish: LiveData<Boolean>
        get() = _eventFactsFinish


    fun setEventGameFinishToFalse(){
        _eventFactsFinish.value=false
    }

    fun setEventGameFinishToTrue(){
        _eventFactsFinish.value=true
    }

    init{
        resetList()
        _eventFactsFinish.value=false
        setWord()
    }

    fun resetList(){

        factsList=mutableListOf<String>(
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


    fun setWord(){
        _word.value=factsList[0]
        factsList.removeAt(0)
    }


    fun checkIfFinishedOrNot(){
        if(factsList.isEmpty()){
            setEventGameFinishToTrue()
        }else{
           setWord()
        }
    }

}