package com.example.counterapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CounterViewModel: ViewModel() {

    var count: Int by mutableStateOf(0)
        private set

    fun increment(){
        count += 1
    }

    fun decrement(){
        if(count > 0){
            count -= 1
        }

    }

    fun reset(){
        count = 0
    }

}

