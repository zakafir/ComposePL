package com.zak.afir.composepl.state_management.assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun TodoScreenRoot(modifier: Modifier) {
    val viewModel = viewModel<ToDoViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    TodoScreen(
        modifier = modifier,
        todoState = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun TodoScreen(todoState: TodoState, onAction: (TodoAction) -> Unit, modifier: Modifier) {
    LazyColumn {
        items(5) {
            TodoItem(modifier = modifier, todoState = todoState, onAction = onAction)
        }
    }
}

@Composable
fun TodoItem(modifier: Modifier, todoState: TodoState, onAction: (TodoAction) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = todoState.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todoState.isChecked)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )
            Text(
                todoState.description,
                textDecoration = if (todoState.isChecked)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )
        }
        Checkbox(
            checked = todoState.isChecked,
            onCheckedChange = { isChecked ->
                onAction(TodoAction.OnClickOnChecked(isChecked))
            })
        IconButton(onClick = { onAction(TodoAction.OnClickDelete) }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TodoScreenPreview() {
    ComposePLTheme {
        TodoScreen(
            todoState = TodoState(
                title = "Bring out the trash",
                description = "Better do this before wife comes home",
                isChecked = false
            ),
            onAction = {

            },
            modifier = Modifier
        )
    }
}

