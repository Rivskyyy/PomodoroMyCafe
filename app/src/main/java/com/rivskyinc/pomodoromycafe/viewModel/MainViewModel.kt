package com.rivskyinc.pomodoromycafe.viewModel

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.time.Duration.Companion.minutes

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val liveDataSeconds = MutableLiveData<String>()
    val livedataMinutes = MutableLiveData<String>()

    var timerData: Long = 1_499_900


    private val _isMusicOn = MutableLiveData<Boolean>()
    val isMusicOn: LiveData<Boolean> = _isMusicOn


    init {
        startMusic()
    }
    fun startMusic() {
        _isMusicOn.value = true
    }
    fun stopMusic() {
        _isMusicOn.value = false
    }


    fun startTimer() {
        object : CountDownTimer(timerData, 1000) {

            override fun onTick(millisUntilFinished: Long) {

                val sec = millisUntilFinished / 1000
                val secConverted = sec % 60
                val min = sec / 60
                val minConverted = min % 60

                liveDataSeconds.value = secConverted.toString()
                livedataMinutes.value = minConverted.toString()
            }

            override fun onFinish() {
                cancel()
            }

        }.start()
    }
}