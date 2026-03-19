package com.gorjetas.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NumericKeyboard(
    onNumberClick: (String) -> Unit,
    onDelete: () -> Unit
) {
    Column {

        val rows = listOf(
            listOf("1","2","3"),
            listOf("4","5","6"),
            listOf("7","8","9"),
            listOf("0","⌫")
        )

        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { key ->
                    Button(
                        onClick = {
                            if (key == "⌫") onDelete()
                            else onNumberClick(key)
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Text(text = key)
                    }
                }
            }
        }
    }
}