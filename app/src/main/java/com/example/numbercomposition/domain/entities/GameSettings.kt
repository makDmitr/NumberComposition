package com.example.numbercomposition.domain.entities

data class GameSettings(
    val maxSumForQuestions: Int,
    val timeForGameRoundInSec: Int,
    val minNumberOfRightAnswersToWin: Int,
    val minPercentOfRightAnswersToWin: Int
)