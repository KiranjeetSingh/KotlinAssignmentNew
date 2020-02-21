package com.example.kotlinassignment.data

import com.example.kotlinassignment.data.Todo
import retrofit2.http.GET

interface TodoListApi {

    @GET("todos")
    suspend fun getTodoList(): List<Todo>


}