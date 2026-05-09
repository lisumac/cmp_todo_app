package org.rdk.todo

import androidx.compose.ui.window.ComposeUIViewController
import org.rdk.todo.di.initializeKoin

fun MainViewController() = ComposeUIViewController(configure = { initializeKoin() }) { App() }