package com.example.kotlinassignment.di

import com.example.kotlinassignment.domain.ToDoUseCase
import com.example.kotlinassignment.domain.TodoRepository
import com.example.kotlinassignment.domain.TodoUseCaseImpl
import dagger.Module
import dagger.Provides

@Module/*(includes = [ViewModelModule::class, ApiModule::class])*/
class UseCaseModule {

    @Provides
    fun provideTodoUseCaseImpl(repository: TodoRepository): ToDoUseCase =
        TodoUseCaseImpl(repository)

}