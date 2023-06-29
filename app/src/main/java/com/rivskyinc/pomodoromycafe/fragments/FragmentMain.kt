package com.rivskyinc.pomodoromycafe.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.pomodoromycafe.R
import com.rivskyinc.pomodoromycafe.databinding.FragmentMainBinding
import com.rivskyinc.pomodoromycafe.viewModel.MainViewModel

class FragmentMain : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var bgMusic: MediaPlayer

    private var baseTimer = 25

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bgMusic = MediaPlayer.create(requireContext(), R.raw.charles_dolle_indigo_rain)
        bgMusic.setOnPreparedListener {
            bgMusic.start()
        }
        bgMusic.setOnCompletionListener {
            bgMusic.start()
        }


        viewModel = ViewModelProvider(this@FragmentMain)[MainViewModel::class.java]

        with(binding) {

            viewModel.livedataMinutes.observe(viewLifecycleOwner) {
                textViewTimerMinutes.text = it
            }

            viewModel.liveDataSeconds.observe(viewLifecycleOwner) {
                textViewTimerSeconds.text = it
            }

            incrementTimer.setOnClickListener {
                viewModel.timerData += 300_000
                baseTimer += 5
                textViewTimerMinutes.text = baseTimer.toString()

            }
            decrementTimer.setOnClickListener {
                viewModel.timerData -= 300_000
                baseTimer -= 5
                textViewTimerMinutes.text = baseTimer.toString()
            }

            buttonStart.setOnClickListener {
                viewModel.startTimer()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        resumeMusicBg()
    }
    override fun onStart() {
        super.onStart()
        resumeMusicBg()
    }
    override fun onPause() {
        super.onPause()
        pauseMusicBg()
    }

    override fun onStop() {
        super.onStop()
       pauseMusicBg()
    }

    private fun pauseMusicBg(){
        bgMusic.pause()
    }
    private fun resumeMusicBg(){
        bgMusic.start()
    }
}