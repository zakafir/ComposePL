package com.zak.afir.composepl.state_management.assignment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        todos = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun TodoScreen(todos: List<TodoState>, onAction: (TodoAction) -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            itemsIndexed(todos) { key , todo ->
                TodoItem(modifier = modifier, todo = todo, index = key, onAction = onAction)
            }
        }
        Row(verticalAlignment = Alignment.Bottom) {
            Column(
                modifier = modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    value = "",
                    onValueChange = { onAction(TodoAction.OnTitleChange(it)) },
                    placeholder = { Text(text = "Title") }
                )
                TextField(
                    value = "",
                    onValueChange = { onAction(TodoAction.OnDescriptionChange(it)) },
                    placeholder = { Text(text = "Description") }
                )
            }
            Button(
                onClick = {
                    onAction(
                        TodoAction.OnAddNewTodo(
                            TodoState(
                                title = "toto",
                                description = "titi",
                                isChecked = false
                            )
                        )
                    )
                }
            ) {
                Text(text = "Add")
            }
        }
    }
}

@Composable
fun TodoItem(modifier: Modifier, todo: TodoState, index: Int, onAction: (TodoAction) -> Unit) {
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
                text = todo.title,
                fontWeight = FontWeight.Bold,
                textDecoration = if (todo.isChecked)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )
            Text(
                todo.description,
                textDecoration = if (todo.isChecked)
                    TextDecoration.LineThrough
                else
                    TextDecoration.None
            )
        }
        Checkbox(
            checked = todo.isChecked,
            onCheckedChange = { isChecked ->
                onAction(TodoAction.OnClickOnChecked(isChecked, index))
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
            todos = listOf(
                TodoState(
                    title = "Bring out the trash",
                    description = "Better do this before wife comes home",
                    isChecked = false
                )
            ),
            onAction = {

            },
            modifier = Modifier
        )
    }
}

