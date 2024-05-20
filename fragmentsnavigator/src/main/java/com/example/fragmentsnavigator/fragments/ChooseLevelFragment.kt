package com.example.fragmentsnavigator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fragmentsnavigator.R
import com.example.fragmentsnavigator.databinding.FragmentChooseLevelBinding
import com.example.fragmentsnavigator.model.GameSettings
import com.example.fragmentsnavigator.model.Level

class ChooseLevelFragment : Fragment() {

    private val binding by lazy {
        FragmentChooseLevelBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickers()
    }

    private fun setClickers() {
        binding.apply {
            traineeLevelBtn.setOnClickListener {
                createGameSettings(Level.TRAINEE)
            }
            easyLevelBtn.setOnClickListener {
                createGameSettings(Level.EASY)
            }
            standardLevelBtn.setOnClickListener {
                createGameSettings(Level.STANDARD)
            }
            hardLevelBtn.setOnClickListener {
                createGameSettings(Level.HARD)
            }
        }
    }

    private fun createGameSettings(level: Level) {
        val gameSettings = when (level) {
            Level.TRAINEE -> GameSettings(
                maxSumValue = 10,
                minCountOfRightAnswer = 5,
                minPercentOfRightAnswers = 20.0,
                gameTimeInSeconds = 20,
            )

            Level.EASY -> GameSettings(
                maxSumValue = 20,
                minCountOfRightAnswer = 8,
                minPercentOfRightAnswers = 30.0,
                gameTimeInSeconds = 30,
            )

            Level.STANDARD -> GameSettings(
                maxSumValue = 30,
                minCountOfRightAnswer = 15,
                minPercentOfRightAnswers = 40.0,
                gameTimeInSeconds = 20,
            )

            Level.HARD -> GameSettings(
                maxSumValue = 80,
                minCountOfRightAnswer = 20,
                minPercentOfRightAnswers = 80.0,
                gameTimeInSeconds = 30,
            )
        }
        openGameFragment(level = level, gameSettings = gameSettings)
    }

    private fun openGameFragment(gameSettings: GameSettings, level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                gameLevel = level,
                gameSettings = gameSettings
            )
        )
    }

}