package com.example.kotlinassignment.di

import com.example.kotlinassignment.data.UserListApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ApiModule {

    @Provides
    @Singleton
    fun provideToDoApi(retrofit: Retrofit): UserListApi {
        return retrofit.create(UserListApi::class.java)
    }
}