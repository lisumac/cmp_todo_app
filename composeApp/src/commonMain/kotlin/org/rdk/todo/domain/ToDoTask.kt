package org.rdk.todo.domain

import kotlin.time.Clock
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

data class ToDoTask @OptIn(ExperimentalUuidApi::class) constructor(
    val id: String = Uuid.random().toHexString(),
    val title: String,
    val description: String,
    val isCompleted: Boolean=false,
    val priority: Priority,
    val createdAt: Long = Clock.System.now().toEpochMilliseconds(),
    val updatedAt : Long = Clock.System.now().toEpochMilliseconds()
)
enum class Priority{
    Low,
    Medium,
    High,
    None
}