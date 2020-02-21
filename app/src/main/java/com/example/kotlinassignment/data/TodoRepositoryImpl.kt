package com.example.kotlinassignment.data

import com.example.kotlinassignment.domain.TodoRepository


class TodoRepositoryImpl(val api: TodoListApi) :
    TodoRepository {

    override suspend fun getTodoList(): List<Todo> {
        return api.getTodoList()
    }
}