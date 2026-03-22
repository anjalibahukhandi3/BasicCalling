package com.intern.callingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DialPadViewModel : ViewModel() {

    private val _inputNumber = MutableLiveData<String>("")
    val inputNumber: LiveData<String> = _inputNumber

    fun appendDigit(digit: String) {
        val current = _inputNumber.value ?: ""
        if (current.length < 15) {
            _inputNumber.value = current + digit
        }
    }

    fun backspace() {
        val current = _inputNumber.value ?: ""
        if (current.isNotEmpty()) {
            _inputNumber.value = current.substring(0, current.length - 1)
        }
    }
    
    fun clear() {
        _inputNumber.value = ""
    }
}
