package com.example.kotlinassignment.domain

import com.example.kotlinassignment.data.Todo

interface ToDoUseCase  {

    suspend fun getTodoList(): List<Todo>
}