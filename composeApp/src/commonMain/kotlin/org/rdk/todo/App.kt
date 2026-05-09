package org.rdk.todo

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.rdk.todo.navigation.NavGraph
import org.rdk.todo.utill.darkScheme
import org.rdk.todo.utill.lightScheme

@Composable
@Preview
fun App() {
    val colorScheme = if (isSystemInDarkTheme()) darkScheme else lightScheme

    MaterialTheme(colorScheme) {
        NavGraph()
    }
}