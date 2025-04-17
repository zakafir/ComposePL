package com.zak.afir.composepl.state_management.assignment

sealed interface TodoAction {
    data object OnClickDelete : TodoAction
    data class OnClickOnChecked(val isChecked: Boolean, val index: Int): TodoAction
    data class OnAddNewTodo(val todo: TodoState): TodoAction
    class OnTitleChange(title: String) : TodoAction
    class OnDescriptionChange(description: String) : TodoAction
}