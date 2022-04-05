package com.alireza.quiz4.data

import com.alireza.quiz4.data.model.UserReqBody
import com.alireza.quiz4.data.model.UserResponse
import com.alireza.quiz4.data.repository.UserRepository

object Mapper {
    fun transformToUser(userResponse: UserResponse): UserReqBody {
        return UserReqBody(
            firstName = userResponse.firstName,
            lastName = userResponse.lastName,
            nationalCode = userResponse.nationalCode,
            hobbies = userResponse.hobbies
        )
    }
}