package com.rivskyinc.pomodoromycafe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.pomodoromycafe.R
import com.rivskyinc.pomodoromycafe.databinding.ActivityMainBinding
import com.rivskyinc.pomodoromycafe.databinding.FragmentMainBinding
import com.rivskyinc.pomodoromycafe.viewModel.MainViewModel

class FragmentMain : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var binding : FragmentMainBinding
    private var base = 25

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false )
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.livedataMinutes.observe(viewLifecycleOwner) {
            binding.textViewTimerMinutes.text = it
        }

        viewModel.liveDataSeconds.observe(viewLifecycleOwner){
            binding.textViewTimerSeconds.text = it
        }

        binding.incrementTimer.setOnClickListener {
            viewModel.timerData += 300_000
            base += 5
            binding.textViewTimerMinutes.text = base.toString()

        }
        binding.decrementTimer.setOnClickListener {
            viewModel.timerData -= 300_000
            base -= 5
            binding.textViewTimerMinutes.text = base.toString()
        }


        binding.buttonStart.setOnClickListener {
            viewModel.startTimer()
        }
    }
}