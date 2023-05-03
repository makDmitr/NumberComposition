package com.example.numbercomposition.domain.entities

data class Question(
    val answer: Int,
    val visibleDigit: Int,
    val options: List<Int>
) {
    val invisibleDigit: Int
        get() = answer - visibleDigit
}
