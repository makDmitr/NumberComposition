package com.example.numbercomposition.data

import com.example.numbercomposition.domain.entities.GameSettings
import com.example.numbercomposition.domain.entities.Level.*
import com.example.numbercomposition.domain.entities.Level
import com.example.numbercomposition.domain.entities.Question
import com.example.numbercomposition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random


object GameRepositoryImpl : GameRepository {

    private const val MINIMUM_RANDOM_SUM_LIMITATION = 2
    private const val MINIMUM_RANDOM_ANSWER_LIMITATION = 1

    override fun generateQuestion(maxSumLimitation: Int, numberOfOptions: Int): Question {
        val sum = Random.nextInt(MINIMUM_RANDOM_SUM_LIMITATION, maxSumLimitation + 1)

        val visibleDigit = Random.nextInt(
            MINIMUM_RANDOM_ANSWER_LIMITATION,
            sum
        )

        val rightAnswer = sum - visibleDigit

        val options = HashSet<Int>()
        options.add(rightAnswer)

        val lowerBoundForRandomDigits = max(
            rightAnswer - numberOfOptions,
            MINIMUM_RANDOM_ANSWER_LIMITATION
        )
        val upperBoundForRandomDigits = min(
            sum,
            rightAnswer + numberOfOptions
        )

        while (options.size != numberOfOptions) {
            val randomDigit = Random.nextInt(
                lowerBoundForRandomDigits,
                upperBoundForRandomDigits
            )
            options.add(randomDigit)
        }

        return Question(sum, visibleDigit, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            TEST -> {
                GameSettings(
                    maxSumForQuestions = 10,
                    timeForGameRoundInSec = 8,
                    minNumberOfRightAnswersToWin = 5,
                    minPercentOfRightAnswersToWin = 50
                )
            }
            EASY -> {
                GameSettings(
                    maxSumForQuestions = 10,
                    timeForGameRoundInSec = 60,
                    minNumberOfRightAnswersToWin = 10,
                    minPercentOfRightAnswersToWin = 80
                )
            }
            MEDIUM -> {
                GameSettings(
                    maxSumForQuestions = 20,
                    timeForGameRoundInSec = 50,
                    minNumberOfRightAnswersToWin = 15,
                    minPercentOfRightAnswersToWin = 90
                )
            }
            HARD -> {
                GameSettings(
                    maxSumForQuestions = 30,
                    timeForGameRoundInSec = 40,
                    minNumberOfRightAnswersToWin = 20,
                    minPercentOfRightAnswersToWin = 100
                )
            }
        }
    }
}



















