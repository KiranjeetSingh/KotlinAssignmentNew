package com.example.kotlinassignment.data

import com.example.kotlinassignment.domain.UserRepository
import retrofit2.Response
import javax.inject.Inject


 class UserRepositoryImpl @Inject constructor(val api: UserListApi) :
    UserRepository {

    override suspend fun getData(): Response<Data> {
        return api.getData()
    }
}