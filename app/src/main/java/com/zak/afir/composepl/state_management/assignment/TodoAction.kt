package com.zak.afir.composepl.state_management.assignment

sealed interface TodoAction {
    data class OnClickDelete(val index: Int) : TodoAction
    data class OnClickOnChecked(val isChecked: Boolean, val index: Int): TodoAction
    data object OnAddNewTodo: TodoAction
    class OnTitleChange(val title: String) : TodoAction
    class OnDescriptionChange(val description: String) : TodoAction
}