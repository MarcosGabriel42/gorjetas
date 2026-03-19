package com.gorjetas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

@Composable
fun TipCard(
    title: String,
    tip: Double,
    total: Double,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = Color(0xFF1E1E1E),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        // Linha de cima (título + gorjeta)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = title,
                color = Color.White
            )

            Text(
                text = "$${String.format("%.2f", tip)}",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Total (maior)
        Text(
            text = "$${String.format("%.2f", total)}",
            color = Color.White,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.align(Alignment.End)
        )
    }
}