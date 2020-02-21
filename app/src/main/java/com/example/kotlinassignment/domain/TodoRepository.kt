package com.example.kotlinassignment.domain

import com.example.kotlinassignment.data.Todo


interface TodoRepository  {
    suspend fun getTodoList(): List<Todo>

}