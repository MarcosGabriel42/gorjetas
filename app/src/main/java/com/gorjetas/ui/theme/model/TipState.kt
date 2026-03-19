package com.gorjetas.model

data class TipState(
    val amount: String = "0.00",
    val customPercentage: Int = 18,
    val tip15: Double = 0.0,
    val tipCustom: Double = 0.0,
    val total15: Double = 0.0,
    val totalCustom: Double = 0.0,
    val isKeyboardVisible: Boolean = false
)