package com.zestworks.todomvikoin.create.repository

import com.zestworks.todomvikoin.database.room.Todo

interface AddTodoRepository {
    fun addTodo(todo: Todo)
}