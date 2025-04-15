package com.zak.afir.composepl.state_management

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun Counter(modifier: Modifier = Modifier) { 
    var items by rememberSaveable {
        mutableStateOf(listOf("Item"))
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                items += "Item"
            }
        ) {
            Text("Add item")
        }
        Text(text = items.toString(), modifier = Modifier.align(Alignment.TopCenter))
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    ComposePLTheme {
        Counter(Modifier)
    }
}