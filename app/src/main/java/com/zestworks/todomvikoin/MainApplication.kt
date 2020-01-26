package com.zestworks.todomvikoin

import android.app.Application
import com.zestworks.todomvikoin.database.di.DatabaseModule
import com.zestworks.todomvikoin.create.di.AddTodoModule
import com.zestworks.todomvikoin.listing.di.TodoListingModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    DatabaseModule,
                    TodoListingModule,
                    AddTodoModule

                )
            )
        }
    }
}