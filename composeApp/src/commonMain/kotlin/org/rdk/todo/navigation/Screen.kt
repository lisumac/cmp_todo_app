package org.rdk.todo.navigation

import kotlinx.serialization.Serializable

/**
 * Screen
 *
 * @constructor Create empty Screen
 * Represent Destination
 */
@Serializable
sealed class Screen {
    @Serializable
    object Home : Screen()

    @Serializable
    data class Task(val id: String? = null) : Screen()
}