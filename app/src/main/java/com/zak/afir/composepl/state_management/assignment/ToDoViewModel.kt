package com.zak.afir.composepl.state_management.assignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ToDoViewModel : ViewModel() {
    private val _state = MutableStateFlow(listOf(TodoState(), TodoState(), TodoState(), TodoState()))
    val state = _state.asStateFlow()

    fun onAction(todoAction: TodoAction) {
        when (todoAction) {
            is TodoAction.OnClickOnChecked -> {
                _state.update {
                    it.mapIndexed { index, todoState ->
                        if (index == todoAction.index) {
                            todoState.copy(isChecked = !todoState.isChecked)
                        } else todoState
                    }
                }
            }

            TodoAction.OnClickDelete -> {

            }

            is TodoAction.OnAddNewTodo -> TODO()
            is TodoAction.OnDescriptionChange -> TODO()
            is TodoAction.OnTitleChange -> TODO()
        }
    }
}

data class TodoState(
    val title: String = "Bring out the trash",
    val description: String = "Better do this before wife comes home",
    val isChecked: Boolean = false
)