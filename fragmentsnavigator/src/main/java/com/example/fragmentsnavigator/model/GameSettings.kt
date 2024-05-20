package com.example.fragmentsnavigator.model

import java.io.Serializable

class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswer: Int,
    val minPercentOfRightAnswers: Double,
    val gameTimeInSeconds: Int,
) : Serializable