package com.zestworks.todomvikoin.create.intent

import com.zestworks.todomvikoin.database.room.Todo

sealed class TodoCreateActionType {
    data class AddTodo(val todo: Todo): TodoCreateActionType()
}