package com.rivskyinc.pomodoromycafe.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.rivskyinc.pomodoromycafe.R
import com.rivskyinc.pomodoromycafe.databinding.FragmentSettingsBinding
import com.rivskyinc.pomodoromycafe.viewModel.MainViewModel


class FragmentSettings : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentSettingsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this@FragmentSettings)[MainViewModel::class.java]
        musicControl()
        buttonClose()


    }

    private fun buttonClose() {
        binding.buttonClose.setOnClickListener {
            val fragmentManager = this@FragmentSettings.requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()


            fragmentTransaction.remove(this@FragmentSettings)
            fragmentTransaction.commit()
        }
    }

    private fun musicControl() {
        binding.buttonMusic.setOnClickListener {

            viewModel.isMusicOn.value?.let { isMusicOn ->
                Log.d("MUSIC_S", isMusicOn.toString())
                if (isMusicOn) {
                    // val getImageToOffMusic = resources.getDrawable(R.drawable.music_off)
                    // binding.buttonMusic.setImageDrawable(getImageToOffMusic)
                    viewModel.stopMusic()
                } else {
                    // val getImageToOnMusic = resources.getDrawable(R.drawable.music_on)
                    // binding.buttonMusic.setImageDrawable(getImageToOnMusic)
                    viewModel.startMusic()
                }
            }
        }
    }


}