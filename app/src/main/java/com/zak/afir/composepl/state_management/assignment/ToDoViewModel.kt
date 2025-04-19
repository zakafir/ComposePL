package com.zak.afir.composepl.state_management.assignment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ToDoViewModel : ViewModel() {
    private val _state = MutableStateFlow(getTodos())
    val state = _state.asStateFlow()

    private val _newAddedTodo = MutableStateFlow(
        TodoState(
            title = "",
            description = ""
        )
    )
    val newAddedTodo = _newAddedTodo.asStateFlow()

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

            is TodoAction.OnClickDelete -> {
                _state.update {
                    it.filterIndexed { index, _ ->
                        index != todoAction.index
                    }
                }
            }

            is TodoAction.OnAddNewTodo -> {
                _state.update {
                    it + _newAddedTodo.value
                }
            }

            is TodoAction.OnDescriptionChange -> {
                _newAddedTodo.update {
                    it.copy(description = todoAction.description)
                }
            }

            is TodoAction.OnTitleChange -> {
                _newAddedTodo.update {
                    it.copy(title = todoAction.title)
                }
            }
        }
    }
}

data class TodoState(
    val index: Int = 0,
    val title: String = "Item $index",
    val description: String = "Description $index",
    val isChecked: Boolean = false
)

fun getTodos(): List<TodoState> {
    val todos = mutableListOf<TodoState>()
    for (i in 0..2) {
        todos.add(TodoState(index = i))
    }
    return todos
}