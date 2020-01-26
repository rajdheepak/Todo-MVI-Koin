package com.zestworks.todomvikoin.listing.intent

sealed class TodoListingActionType {
    data class DeleteTodo(val todoId: String): TodoListingActionType()
    data class UpdateTodoStatus(val todoId: String, val status: Boolean): TodoListingActionType()
}