package com.example.fragmentsnavigator.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsnavigator.R
import com.example.fragmentsnavigator.databinding.FragmentGameBinding
import com.example.fragmentsnavigator.model.GameResult
import com.example.fragmentsnavigator.model.Question
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random


class GameFragment : Fragment() {

    private val binding by lazy {
        FragmentGameBinding.inflate(layoutInflater)
    }

    private val args by navArgs<GameFragmentArgs>()

    private lateinit var timer: CountDownTimer

    private lateinit var question: Question
    private var answerCount: Int = 0
    private var countOfCorrectAnswer: Int = 0
    private var maxSum = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        maxSum = args.gameSettings.maxSumValue
        generateQuesion()
    }

    override fun onResume() {
        super.onResume()
        startTimer()
        setVariantClickers()
    }

    private fun generateQuesion() {
        val sum = Random.nextInt(MIN_SUM_VALUE,  maxSum + MIN_SUM_VALUE)
        val visibleNum = Random.nextInt(MIN_VARIANT_VALUE, sum)
        val correctAnswer = sum - visibleNum
        val variants = HashSet<Int>()
        variants.add(correctAnswer)
        while (variants.size < COUNT_OF_OPTIONS) {
            val option = Random.nextInt(MIN_VARIANT_VALUE, sum)
            variants.add(option)
        }
        question = Question(
            sum = sum,
            visibleNum = visibleNum,
            variants = variants,
            correctAnswer = correctAnswer
        )
        initViews()
    }

    private fun setVariantClickers() {
        var userNum = 0
        binding.apply {
            num1.setOnClickListener {
                userNum = tvNum1.text.toString().toInt()
                nextQuestion(userNum)
            }
            num2.setOnClickListener {
                userNum = tvNum2.text.toString().toInt()
                nextQuestion(userNum)
            }
            num3.setOnClickListener {
                userNum = tvNum3.text.toString().toInt()
                nextQuestion(userNum)
            }
            num4.setOnClickListener {
                userNum = tvNum4.text.toString().toInt()
                nextQuestion(userNum)
            }
            num5.setOnClickListener {
                userNum = tvNum5.text.toString().toInt()
                nextQuestion(userNum)
            }
            num6.setOnClickListener {
                userNum = tvNum6.text.toString().toInt()
                nextQuestion(userNum)
            }
        }
    }

    private fun nextQuestion(userAnswer: Int) {
        answerCount++
        checkAnswer(userAnswer)
        generateQuesion()
    }

    private fun checkAnswer(userAnswer: Int) {
        if (userAnswer == question.correctAnswer) {
            countOfCorrectAnswer++
        }
    }


    private fun initViews() {
        val list: List<Int> = question.variants.toList()
        binding.apply {
            tvSum.text = question.sum.toString()
            visibleNumberTv.text = question.visibleNum.toString()
            binding.tvNum1.text = list[0].toString()
            binding.tvNum2.text = list[1].toString()
            binding.tvNum3.text = list[2].toString()
            binding.tvNum4.text = list[3].toString()
            binding.tvNum5.text = list[4].toString()
            binding.tvNum6.text = list[5].toString()
        }
    }

    private fun startTimer() {
        val seconds = args.gameSettings.gameTimeInSeconds
        parseLongMillis(seconds * MILLIS_IN_SECONDS)
        timer = object : CountDownTimer(seconds * MILLIS_IN_SECONDS, MILLIS_IN_SECONDS) {
            override fun onTick(millis: Long) {
                parseLongMillis(millis)
            }

            override fun onFinish() {
                Toast.makeText(requireContext(), "GameFinished", Toast.LENGTH_SHORT).show()
                openGameFinishFragment()
            }
        }
        timer.start()
    }

    private fun openGameFinishFragment() {
        val correctAnswerPercent = (100 / answerCount) * countOfCorrectAnswer
        val gameResult = GameResult(
            isWinner = args.gameSettings.minCountOfRightAnswer <= countOfCorrectAnswer && args.gameSettings.minPercentOfRightAnswers <= correctAnswerPercent,
            gameSettings = args.gameSettings,
            countOfCorrectAnswer = countOfCorrectAnswer,
            countOfAnswer = answerCount,
            correctAnswerPercent = correctAnswerPercent.toDouble()
        )
        findNavController().navigate(
            GameFragmentDirections.actionGameFragmentToGameResultFragment(gameResult = gameResult, gameLevel = args.gameLevel)
        )
    }

    private fun parseLongMillis(millis: Long) {
        val seconds = millis / MILLIS_IN_SECONDS
        val minutes = seconds / SECONDS_IN_MINUTES
        val leftSeconds = seconds - (minutes * SECONDS_IN_MINUTES)
        if (minutes == 0L && leftSeconds <= 5L) {
            binding.timer.setTextColor(requireActivity().resources.getColor(R.color.red))
        }
        val text = String.format("%02d:%02d", minutes, leftSeconds)
        binding.timer.text = text
    }

    override fun onPause() {
        super.onPause()
        timer.cancel()
    }

    companion object {
        const val COUNT_OF_OPTIONS = 6
        const val SECONDS_IN_MINUTES = 60
        const val MILLIS_IN_SECONDS = 1000L
        const val MIN_VARIANT_VALUE = 2
        const val MIN_SUM_VALUE = 10
    }


}