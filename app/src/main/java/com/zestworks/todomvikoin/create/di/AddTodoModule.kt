package com.zestworks.todomvikoin.create.di

import com.zestworks.todomvikoin.create.repository.AddTodoRepository
import com.zestworks.todomvikoin.create.repository.AddTodoRepositoryimpl
import com.zestworks.todomvikoin.create.viewModel.AddTodoViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AddTodoModule = module {
    viewModel {
        AddTodoViewModel(get())
    }

    single<AddTodoRepository> {
        AddTodoRepositoryimpl(get())
    }
}