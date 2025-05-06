package com.ecmall.ec_mall.presentation.user.createUser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    @SerialName("user_name") val userName: String,
    val email: String,
    val password: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
) {
    fun validate(): CreateUserParam {
        require(userName.isNotBlank()) { "ユーザー名は必須です" }
        return CreateUserParam(
            userName = userName,
            email = email,
            password = password,
            firstName = firstName,
            lastName = lastName
        )
    }
}

data class CreateUserParam(
    val userName: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
