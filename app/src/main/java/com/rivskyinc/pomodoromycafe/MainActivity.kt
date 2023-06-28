package com.rivskyinc.pomodoromycafe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.pomodoromycafe.databinding.ActivityMainBinding
import com.rivskyinc.pomodoromycafe.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
//        viewModel.livedataMinutes.observe(this) {
//            binding.textViewTimerMinutes.text = it
//        }
//        viewModel.liveDataSeconds.observe(this){
//            binding.textViewTimerSeconds.text = it
//        }
//
//        binding.incrementTimer.setOnClickListener {
//            viewModel.timerData += 300_000
//            base += 5
//            binding.textViewTimerMinutes.text = base.toString()
//
//        }
//        binding.decrementTimer.setOnClickListener {
//            viewModel.timerData -= 300_000
//            base -= 5
//            binding.textViewTimerMinutes.text = base.toString()
//        }
//
//
//        binding.buttonStart.setOnClickListener {
//            viewModel.startTimer()
//        }
    }
}