package com.example.kotlinassignment.domain

import com.example.kotlinassignment.data.Data
import retrofit2.Response


interface UserRepository  {
    suspend fun getData(): Response<Data>

}