package com.zestworks.todomvikoin.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDB: RoomDatabase() {
    abstract val todoDao: TodoDao

    companion object {
        private var todoDb: TodoDB? = null
        fun getDb(context: Context): TodoDB? {
            if(todoDb == null) {
                synchronized(this) {
                    todoDb = Room.databaseBuilder(context,TodoDB::class.java,"todo").build()
                    return todoDb
                }
            }
            return todoDb
        }
    }
}