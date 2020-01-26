package com.zestworks.todomvikoin.create.repository

import com.zestworks.todomvikoin.database.room.Todo
import com.zestworks.todomvikoin.database.room.TodoDao

class AddTodoRepositoryimpl(private val todoDao: TodoDao): AddTodoRepository {

    override fun addTodo(todo: Todo) {
        todoDao.addTodo(todo)
    }

}