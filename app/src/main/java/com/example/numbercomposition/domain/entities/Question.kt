package com.example.numbercomposition.domain.entities

data class Question(
    val sum: Int,
    val visibleDigit: Int,
    val options: List<Int>
) {
    val invisibleDigit: Int
        get() = sum - visibleDigit
}
