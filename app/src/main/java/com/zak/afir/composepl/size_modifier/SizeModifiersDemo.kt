package com.zak.afir.composepl.size_modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zak.afir.composepl.utility.printConstraints

@Composable
fun SizeModifiersDemo() {
    Row(
        modifier = Modifier
            .height(100.dp) // Constraints(0, 1080, 0, 3000)
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .printConstraints("Before 1. fillMaxWidth") // Constraints(1080, 1080, 100, 3000)
                .width(300.dp)
                .printConstraints("After 1. fillMaxWidth") // Constraints(1000, 1000, 100, 3000)
                .background(Color.Yellow)
        )
        Box(
            modifier = Modifier
                .height(100.dp) // Constraints(1000, 1000, 100, 3000)
                .printConstraints("Before 2. fillMaxWidth")
                .width(300.dp)
                .printConstraints("After 2. fillMaxWidth")
                .background(Color.Green)
        )
    }
}

@Preview
@Composable
fun SizeModifiersDemoPreview() {
    SizeModifiersDemo()
}