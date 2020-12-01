package com.example.kotlinassignment.data
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface UserListApi {

    @GET("public-api/users")
    suspend fun getData(): Response<Data>

}