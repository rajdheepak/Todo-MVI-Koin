package com.zestworks.todomvikoin.listing.repository

import com.zestworks.todomvikoin.database.room.Todo
import com.zestworks.todomvikoin.database.room.TodoDao
import kotlinx.coroutines.flow.Flow

class TodoListingRepositoryImpl(private val todoDao: TodoDao): TodoListingRepository {
    override fun deleteTodo(id: String) {
        todoDao.deleteTodo(id)
    }

    override fun updateStatus(id: String, done: Boolean) {
        todoDao.updateStatus(id, done)
    }

    override fun getTodo(): Flow<List<Todo>> {
        return todoDao.getTodos()
    }
}