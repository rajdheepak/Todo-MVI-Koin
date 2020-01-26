package com.zestworks.todomvikoin.database.room

import androidx.room.Entity

@Entity(tableName = "todo", primaryKeys = ["id"])
data class Todo (
    var id: String,
    val todo: String,
    val done: Boolean
)