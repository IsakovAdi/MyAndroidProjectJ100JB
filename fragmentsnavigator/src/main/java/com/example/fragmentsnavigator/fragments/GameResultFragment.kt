package com.example.fragmentsnavigator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.fragmentsnavigator.R
import com.example.fragmentsnavigator.databinding.FragmentGameResultBinding
import com.example.fragmentsnavigator.model.Level

class GameResultFragment : Fragment() {
    private val binding by lazy {
        FragmentGameResultBinding.inflate(layoutInflater)
    }

    private val args by navArgs<GameResultFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val gameResult = args.gameResult
        binding.apply {
            gameResult.apply {
                correctAnswerResult.text = countOfCorrectAnswer.toString()
                countOfAnswerResult.text = countOfAnswer.toString()
                correctAnswerPercentResult.text = correctAnswerPercent.toString()
                gameLevelResult.text = when (args.gameLevel) {
                    Level.EASY -> getString(R.string.easy)
                    Level.TRAINEE -> getString(R.string.trainee)
                    Level.STANDARD -> getString(R.string.standard)
                    Level.HARD -> getString(R.string.hard)
                }
                when (isWinner) {
                    true -> gameResultImage.setImageDrawable(resources.getDrawable(R.drawable.ic_smile))
                    false -> gameResultImage.setImageDrawable(resources.getDrawable(R.drawable.ic_cry))
                }

            }
        }
    }
}