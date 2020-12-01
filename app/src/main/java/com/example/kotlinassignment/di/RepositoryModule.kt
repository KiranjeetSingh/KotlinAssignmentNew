package com.example.kotlinassignment.di

import com.example.kotlinassignment.domain.UserRepository
import com.example.kotlinassignment.data.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [ApiModule::class])
abstract class RepositoryModule {

    @Binds
    abstract fun provideUserListRepository(api: UserRepositoryImpl): UserRepository

}