package com.zak.afir.composepl.basic_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowWidthSizeClass
import com.zak.afir.composepl.ui.theme.ComposePLTheme

@Composable
fun WindowSizeClassDemo(modifier: Modifier = Modifier) {
    val windowSize = currentWindowAdaptiveInfo().windowSizeClass

    Scaffold { innerPadding ->

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (windowSize.windowWidthSizeClass) {
                WindowWidthSizeClass.COMPACT, WindowWidthSizeClass.MEDIUM -> {
                    MyLazyList(modifier = modifier)
                }

                WindowWidthSizeClass.EXPANDED -> {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(3f)
                                .background(Color.Red)
                        ) {
                            Text(text = "Menu option 1")
                            Text(text = "Menu option 2")
                            Text(text = "Menu option 3")
                        }
                        MyLazyList(modifier = Modifier.weight(7f).fillMaxHeight())
                    }
                }
            }
        }
    }
}

@Composable
fun MyLazyList(modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(40) {
            Text(modifier = modifier.padding(16.dp), text = "Item $it")
        }
    }
}

@PreviewScreenSizes
@Preview(showBackground = true)
@Composable
fun WindowSizeClassDemoPreview() {
    ComposePLTheme {
        WindowSizeClassDemo()
    }
}