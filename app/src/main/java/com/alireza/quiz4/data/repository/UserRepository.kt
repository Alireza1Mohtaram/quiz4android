package com.alireza.quiz4.data.repository

import androidx.lifecycle.LiveData
import com.alireza.quiz4.data.DataSource
import com.alireza.quiz4.data.Mapper
import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UserRepository(
    private val remoteDataSource: DataSource,
) {

    companion object {
        const val TAG = "Repository"
    }

     suspend fun getUserList(filters: HashMap<String, String>) : Response<List<UserResponse>> {
         return remoteDataSource.getUserList(filters)
    }
      suspend fun createUser(userResponse: UserReqBody) : Response<String>{
         return remoteDataSource.create(userResponse)
    }
}