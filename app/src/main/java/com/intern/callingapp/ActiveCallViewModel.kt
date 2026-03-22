package com.intern.callingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class ActiveCallViewModel : ViewModel() {

    private val _callDuration = MutableLiveData<String>("00:00")
    val callDuration: LiveData<String> = _callDuration

    private val _isMuted = MutableLiveData<Boolean>(false)
    val isMuted: LiveData<Boolean> = _isMuted

    private val _isSpeakerOn = MutableLiveData<Boolean>(false)
    val isSpeakerOn: LiveData<Boolean> = _isSpeakerOn

    private var timerJob: Job? = null
    private var seconds = 0

    init {
        startTimer()
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (isActive) {
                delay(1000)
                seconds++
                _callDuration.value = formatSeconds(seconds)
            }
        }
    }

    private fun formatSeconds(totalSeconds: Int): String {
        val minutes = totalSeconds / 60
        val secs = totalSeconds % 60
        return String.format("%02d:%02d", minutes, secs)
    }

    fun toggleMute() {
        _isMuted.value = !(_isMuted.value ?: false)
    }

    fun toggleSpeaker() {
        _isSpeakerOn.value = !(_isSpeakerOn.value ?: false)
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
