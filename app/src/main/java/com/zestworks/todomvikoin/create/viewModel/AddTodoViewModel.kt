package com.zestworks.todomvikoin.create.viewModel

import androidx.lifecycle.ViewModel
import com.zestworks.todomvikoin.create.intent.TodoCreateActionType
import com.zestworks.todomvikoin.create.repository.AddTodoRepository
import kotlinx.coroutines.*

class AddTodoViewModel(private val addTodoRepository: AddTodoRepository): ViewModel() {

    val job = Job()
    var todoAppScope = CoroutineScope(Dispatchers.Main + job)

    fun performIntent(todoCreateActionType: TodoCreateActionType) {
        when(todoCreateActionType) {
            is TodoCreateActionType.AddTodo -> {
                todoAppScope.launch(Dispatchers.IO) {
                    addTodoRepository.addTodo(todoCreateActionType.todo)
                }
            }
        }
    }
}