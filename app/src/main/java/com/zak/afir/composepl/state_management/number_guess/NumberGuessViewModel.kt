package com.zak.afir.composepl.state_management.number_guess

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NumberGuessViewModel: ViewModel() {
    private val _state = MutableStateFlow(NumberGuessState())
    val state = _state.asStateFlow()
}