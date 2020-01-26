package com.zestworks.todomvikoin.database.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Query("SELECT * from todo order by Done asc")
    fun getTodos(): Flow<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE from Todo where id = :id")
    fun deleteTodo(id: String)

    @Query("UPDATE Todo SET Done = :done where id = :id")
    fun updateStatus(id: String, done: Boolean)

}