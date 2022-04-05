package com.alireza.quiz4


import com.alireza.quiz4.data.DataSource
import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import com.alireza.quiz4.data.network.UserApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class RemoteDataSource(private val userApi: UserApi): DataSource {

    override suspend fun getUserList(filters: HashMap<String, String>) : Response<List<UserResponse>> {
         return userApi.getUserList(filters)
    }

    override suspend fun saveUserList(users: List<UserResponse>) {

    }

    override  suspend fun create(user: UserReqBody) :  Response<String>{
        return userApi.createUser(user)
    }


}