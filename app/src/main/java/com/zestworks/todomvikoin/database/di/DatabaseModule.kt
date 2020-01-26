package com.zestworks.todomvikoin.database.di

import com.zestworks.todomvikoin.database.room.TodoDB
import org.koin.dsl.module

val  DatabaseModule = module {
    single {
        TodoDB.getDb(get())?.todoDao
    }
}