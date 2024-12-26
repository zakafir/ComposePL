@file:OptIn(ExperimentalFoundationApi::class)

package com.zak.afir.composepl.basic_layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun LazyListDemo(modifier: Modifier = Modifier) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(16.dp)) {
        items(100) {
            Text(text = "Item $it")
        }
        stickyHeader {
            Text(
                text = "Header",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green)
            )
        }
        items(100) {
            Text(text = "Item ${it + 100}")
        }
        item {
            Text(
                text = "Reached the end!",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LazyListDemoPreview() {
    ComposePLTheme {
        LazyListDemo()
    }
}