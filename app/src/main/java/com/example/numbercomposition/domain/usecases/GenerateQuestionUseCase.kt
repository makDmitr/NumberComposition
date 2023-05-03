package com.example.numbercomposition.domain.usecases

import com.example.numbercomposition.domain.entities.Question
import com.example.numbercomposition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

    operator fun invoke(maxSumLimitation: Int): Question {
        return repository.generateQuestion(maxSumLimitation, NUMBER_OF_OPTIONS)
    }

    private companion object{
        private const val NUMBER_OF_OPTIONS = 6
    }
}