package com.alireza.quiz4.data

import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DataSource {
    suspend fun getUserList(filters: HashMap<String, String>): Response<List<UserResponse>>
    suspend fun saveUserList(users: List<UserResponse>)
    suspend fun create(user: UserReqBody) : Response<String>
}