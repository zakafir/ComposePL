package com.zak.afir.composepl.state_management.assignment

sealed interface TodoAction {
    data object OnClickDelete : TodoAction
    data class OnClickOnChecked(val isChecked: Boolean): TodoAction
}