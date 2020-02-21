package com.example.kotlinassignment.domain

class TodoUseCaseImpl(private val todoRepository: TodoRepository) :
    ToDoUseCase {
    override suspend fun getTodoList() = todoRepository.getTodoList()
}