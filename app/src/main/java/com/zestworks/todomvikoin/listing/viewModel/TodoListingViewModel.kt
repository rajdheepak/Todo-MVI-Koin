package com.zestworks.todomvikoin.listing.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zestworks.todomvikoin.database.room.Todo
import com.zestworks.todomvikoin.listing.intent.TodoListingActionType
import com.zestworks.todomvikoin.listing.repository.TodoListingRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect

class TodoListingViewModel(private val todoListingRepository: TodoListingRepository) : ViewModel() {

    private val todoList: MutableLiveData<List<Todo>> = MutableLiveData()
    val todoListData: LiveData<List<Todo>> = todoList
    val job = Job()
    var todoAppScope = CoroutineScope(Dispatchers.Main + job)

    init {
        GlobalScope.launch {
            todoListingRepository.getTodo().collect {
                todoList.postValue(it)
            }
        }
    }

    fun performIntent(todoListingActionType: TodoListingActionType) {
        when(todoListingActionType) {
            is TodoListingActionType.DeleteTodo -> {
                todoAppScope.launch(Dispatchers.IO) {
                    todoListingRepository.deleteTodo(todoListingActionType.todoId)
                }
            }
            is TodoListingActionType.UpdateTodoStatus -> {
                todoAppScope.launch(Dispatchers.IO) {
                    todoListingRepository.updateStatus(
                        todoListingActionType.todoId,
                        todoListingActionType.status
                    )
                }
            }
        }
    }
}