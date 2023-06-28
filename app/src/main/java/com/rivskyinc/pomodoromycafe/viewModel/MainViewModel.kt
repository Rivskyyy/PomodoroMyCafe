package com.rivskyinc.pomodoromycafe.viewModel

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlin.time.Duration.Companion.minutes

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val liveDataSeconds =MutableLiveData<String>()
    val livedataMinutes = MutableLiveData<String>()

    var timerData : Long = 1_500_000


fun startTimer(){
      object: CountDownTimer(timerData, 1000){

        override fun onTick(millisUntilFinished: Long) {

            val sec = millisUntilFinished/1000
            val secConverted = sec % 60
            val min = sec  /  60
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