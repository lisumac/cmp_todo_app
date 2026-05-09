package org.rdk.todo.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.koinInject

@Composable
actual fun NavGraph() {

    val navigator = koinInject<Navigator>()
    NavDisplay(backStack = navigator.backStack , onBack = { navigator.backStack}, entryProvider = entryProvider{
        entry<Screen.Home>{
            Text("Hello World")
        }
        entry <Screen.Task>{}

    })
}