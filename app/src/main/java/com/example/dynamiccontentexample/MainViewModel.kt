package com.example.dynamiccontentexample

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val textFieldState = MutableLiveData("")

    fun onTextChanged(name: String) {
        textFieldState.value = name
    }
}