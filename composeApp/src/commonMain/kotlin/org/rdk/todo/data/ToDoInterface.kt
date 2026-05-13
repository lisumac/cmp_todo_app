package org.rdk.todo.data

import kotlinx.coroutines.flow.Flow
import org.rdk.todo.domain.ToDoTask
import org.rdk.todo.utill.RequestState
import kotlin.coroutines.CoroutineContext

interface ToDoInterface {

    fun createTask(task: ToDoTask): RequestState<Unit>
    fun updateTask(task: ToDoTask): RequestState<Unit>
    fun readSelectedTask(taskId: String): RequestState<ToDoTask>
    fun readAllTask(task: CoroutineContext): Flow<RequestState<List<ToDoTask>>>
    fun removeTask(taskId: String): RequestState<Unit>
}