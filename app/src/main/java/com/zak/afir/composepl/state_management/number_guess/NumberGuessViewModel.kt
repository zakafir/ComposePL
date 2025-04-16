package com.zak.afir.composepl.state_management.number_guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.random.Random

class NumberGuessViewModel : ViewModel() {

    private var number = Random.nextInt(1, 101)
    private var attempts = 0

    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()

    fun onAction(action: NumberGuessAction) {
        when (action) {
            NumberGuessAction.OnGuessClick -> {
                val guess = state.value.numberText.toIntOrNull()
                if (guess != null) {
                    attempts++
                }
                _state.update {
                    it.copy(
                        guessText = when {
                            guess == null -> "Please enter a number"
                            guess < number -> "Higher"
                            guess > number -> "Lower"
                            else -> "You win! It took you $attempts attempts."
                        },
                        isGuessCorrect = guess == number,
                        numberText = ""
                    )
                }
            }

            is NumberGuessAction.OnNumberTextGuessChange -> {
                _state.update {
                    it.copy(numberText = action.numberText)
                }
            }

            NumberGuessAction.OnStartNewGameButtonClick -> {
                number = Random.nextInt(1, 101)
                attempts = 0
                _state.update {
                    it.copy(guessText = null, isGuessCorrect = false, numberText = "")
                }
            }
        }
    }
}