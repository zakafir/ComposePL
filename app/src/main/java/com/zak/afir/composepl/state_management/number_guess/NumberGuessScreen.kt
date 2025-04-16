package com.zak.afir.composepl.state_management.number_guess

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zak.afir.composepl.ui.theme.ComposePLTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun NumberGuessScreenRoot(modifier: Modifier) {
    val viewModel = viewModel<NumberGuessViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    NumberGuessScreen(modifier = modifier, state = state, onAction = viewModel::onAction)
}

@Composable
fun NumberGuessScreen(
    modifier: Modifier,
    state: NumberGuessState,
    onAction: (NumberGuessAction) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        TextField(
            value = state.numberText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newText ->
                onAction(NumberGuessAction.OnNumberTextGuessChange(newText))
            }
        )
        Button(
            onClick = { onAction(NumberGuessAction.OnGuessClick) }
        ) {
            Text(text = "Make Guess")
        }
        if (state.guessText != null) {
            Text(
                text = state.guessText
            )
        }
        if (state.isGuessCorrect) {
            Button(
                onClick = { onAction(NumberGuessAction.OnStartNewGameButtonClick) }
            ) {
                Text(text = "Start new game")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NumberGuessScreenPreview() {
    ComposePLTheme {
        NumberGuessScreen(
            modifier = Modifier, state = NumberGuessState(
                numberText = "123"
            ), onAction = {}
        )
    }
}