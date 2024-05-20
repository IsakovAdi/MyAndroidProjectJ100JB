package com.example.fragmentsnavigator.model

import java.io.Serializable

class GameResult(
    val isWinner: Boolean,
    val gameSettings: GameSettings,
    val countOfCorrectAnswer: Int,
    val countOfAnswer: Int,
    val correctAnswerPercent: Double,
):Serializable {
}