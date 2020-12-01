package com.example.kotlinassignment.domain

import javax.inject.Inject

class UserUseCaseImpl @Inject constructor(val userRepository: UserRepository) : UserUseCase {
    override suspend fun getData() = userRepository.getData()
}