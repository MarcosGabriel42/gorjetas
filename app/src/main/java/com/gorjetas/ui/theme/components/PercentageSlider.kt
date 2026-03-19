package com.gorjetas.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PercentageSlider(
    percentage: Int,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        // Texto de cima
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Custom Tip")
            Text(text = "$percentage%")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Slider
        Slider(
            value = percentage.toFloat(),
            onValueChange = onValueChange,
            valueRange = 0f..30f
        )
    }
}