package com.example.kotlinassignment.di

import com.example.kotlinassignment.domain.UserUseCase
import com.example.kotlinassignment.domain.UserUseCaseImpl
import dagger.Binds
import dagger.Module

@Module/*(includes = [ViewModelModule::class, ApiModule::class])*/
abstract class UseCaseModule {

    @Binds
    abstract fun provideUserUseCaseImpl(repository: UserUseCaseImpl): UserUseCase

}