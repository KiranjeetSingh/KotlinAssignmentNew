package com.example.kotlinassignment.di

import com.example.kotlinassignment.data.TodoListApi
import com.example.kotlinassignment.domain.TodoRepository
import com.example.kotlinassignment.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class RepositoryModule {

    @Provides
    fun provideTodoListRepository(api: TodoListApi): TodoRepository {
        return TodoRepositoryImpl(api)
    }
}