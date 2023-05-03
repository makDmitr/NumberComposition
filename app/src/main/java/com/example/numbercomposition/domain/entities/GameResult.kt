package com.example.numbercomposition.domain.entities

data class GameResult(
    val isWinner: Boolean,
    val numberOfAnsweredQuestions: Int,
    val numberOfQuestions: Int,
    val gameSettings: GameSettings
)
