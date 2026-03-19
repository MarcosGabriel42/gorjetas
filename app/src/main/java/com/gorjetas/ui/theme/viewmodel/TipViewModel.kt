package com.gorjetas.viewmodel

import androidx.lifecycle.ViewModel
import com.gorjetas.model.TipState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class TipViewModel : ViewModel() {

    private val _state = MutableStateFlow(TipState())
    val state: StateFlow<TipState> = _state

    // 🔥 Mostrar teclado
    fun showKeyboard() {
        _state.update { it.copy(isKeyboardVisible = true) }
    }

    // 🔥 Esconder teclado (opcional)
    fun hideKeyboard() {
        _state.update { it.copy(isKeyboardVisible = false) }
    }

    // 🔢 Clique nos números
    fun onNumberClick(number: String) {
        _state.update { current ->
            val raw = current.amount.replace(".", "") + number
            val formatted = formatAmount(raw)
            calculate(formatted, current.customPercentage, current.isKeyboardVisible)
        }
    }

    // ⌫ Delete
    fun onDelete() {
        _state.update { current ->
            val raw = current.amount.replace(".", "").dropLast(1)
            val formatted = formatAmount(raw)
            calculate(formatted, current.customPercentage, current.isKeyboardVisible)
        }
    }

    // 🎚 Slider
    fun onSliderChange(value: Float) {
        _state.update { current ->
            calculate(current.amount, value.toInt(), current.isKeyboardVisible)
        }
    }

    // 🧠 Cálculos
    private fun calculate(
        amountStr: String,
        custom: Int,
        isKeyboardVisible: Boolean
    ): TipState {

        val amount = amountStr.toDoubleOrNull() ?: 0.0

        val tip15 = amount * 0.15
        val tipCustom = amount * (custom / 100.0)

        return TipState(
            amount = amountStr,
            customPercentage = custom,
            tip15 = tip15,
            tipCustom = tipCustom,
            total15 = amount + tip15,
            totalCustom = amount + tipCustom,
            isKeyboardVisible = isKeyboardVisible
        )
    }

    // 💰 Formatação
    private fun formatAmount(raw: String): String {
        val value = raw.toDoubleOrNull()?.div(100) ?: 0.0
        return String.format("%.2f", value)
    }
}