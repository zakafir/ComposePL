package com.zak.afir.composepl.state_management.number_guess

sealed interface NumberGuessAction {
    data object OnGuessClick : NumberGuessAction
    data class OnNumberTextGuessChange(val numberText: String) : NumberGuessAction
    data object OnStartNewGameButtonClick : NumberGuessAction
}