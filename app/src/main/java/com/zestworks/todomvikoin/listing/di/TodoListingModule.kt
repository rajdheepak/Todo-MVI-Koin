package com.zestworks.todomvikoin.listing.di

import com.zestworks.todomvikoin.listing.repository.TodoListingRepository
import com.zestworks.todomvikoin.listing.repository.TodoListingRepositoryImpl
import com.zestworks.todomvikoin.listing.viewModel.TodoListingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  TodoListingModule = module {

    viewModel {
        TodoListingViewModel(get())
    }

    single<TodoListingRepository> {
        TodoListingRepositoryImpl(get())
    }
}