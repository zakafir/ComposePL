package com.zak.afir.composepl.size_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SizeModifiersDemo() {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(fraction = 0.5f)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(fraction = 0.5f)
                .background(Color.Green)
        )
    }
}

@Preview
@Composable
fun SizeModifiersDemoPreview() {
    SizeModifiersDemo()
}