package com.zak.afir.composepl.state_management.number_guess

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun NumberGuessScreen(modifier: Modifier) {
    
}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    ComposePLTheme {
        NumberGuessScreen(modifier = Modifier)
    }
}