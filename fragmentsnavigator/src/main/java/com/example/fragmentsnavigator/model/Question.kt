package com.example.fragmentsnavigator.model

class Question(
    val sum:Int,
    val visibleNum:Int,
    val variants:Set<Int>,
    val correctAnswer:Int = sum - visibleNum
)