package com.gorjetas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gorjetas.viewmodel.TipViewModel
import com.gorjetas.ui.components.*

@Composable
fun TipScreen(
    viewModel: TipViewModel = viewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // 💰 Amount (clicável)
        AmountDisplay(
            amount = state.amount,
            onClick = { viewModel.showKeyboard() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🎚 Slider
        PercentageSlider(
            percentage = state.customPercentage,
            onValueChange = { viewModel.onSliderChange(it) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📊 Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TipCard(
                title = "15%",
                tip = state.tip15,
                total = state.total15,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            TipCard(
                title = "${state.customPercentage}%",
                tip = state.tipCustom,
                total = state.totalCustom,
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // 🔥 TECLADO (só aparece quando clicar)
        if (state.isKeyboardVisible) {
            NumericKeyboard(
                onNumberClick = { viewModel.onNumberClick(it) },
                onDelete = { viewModel.onDelete() }
            )
        }
    }
}