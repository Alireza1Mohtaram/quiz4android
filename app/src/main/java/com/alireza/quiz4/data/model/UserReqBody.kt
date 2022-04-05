package com.alireza.quiz4.data.model

data class UserReqBody(
    val firstName: String,
    val hobbies: List<String>?,
    val lastName: String,
    val nationalCode: String
)