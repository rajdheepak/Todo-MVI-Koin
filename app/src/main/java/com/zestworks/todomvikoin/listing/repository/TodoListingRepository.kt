package com.zestworks.todomvikoin.listing.repository

import com.zestworks.todomvikoin.database.room.Todo
import kotlinx.coroutines.flow.Flow

interface TodoListingRepository {
    fun deleteTodo(id: String)
    fun updateStatus(id: String, done: Boolean)
    fun getTodo(): Flow<List<Todo>>
}