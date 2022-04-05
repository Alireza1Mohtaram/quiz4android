package com.alireza.quiz4.data.network


import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @GET("users")
    suspend fun getUserList(@QueryMap filters: HashMap<String, String> = hashMapOf()): Response<List<UserResponse>>

    @POST("users")
   suspend fun createUser(
        @Body userReqBody: UserReqBody
    ): Response<String>

    @Multipart
    @POST("users/{id}/image")
    suspend fun uploadImage(
        @Path("id") id: String,
        @Part image: MultipartBody.Part
    ): Response<Any>
}