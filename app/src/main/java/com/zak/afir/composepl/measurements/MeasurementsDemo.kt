package com.zak.afir.composepl.measurements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun MeasurementDemo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
    ) {
        Text(
            text = "This is a text",
            modifier = Modifier.background(
                Color.Yellow
            )
        )
        Text(
            text = "This is another text",
            modifier = Modifier.background(
                Color.Green
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MeasurementDemoPreview() {
    ComposePLTheme {
        MeasurementDemo()
    }
}