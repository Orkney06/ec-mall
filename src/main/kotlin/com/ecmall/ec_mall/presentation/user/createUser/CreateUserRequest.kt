package com.ecmall.ec_mall.presentation.user.createUser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserRequest(
    @SerialName("userName") val userName: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String,
    @SerialName("firstName") val firstName: String,
    @SerialName("lastName") val lastName: String,
) {
    fun toParam(): CreateUserParam {
        return CreateUserParam(
            userName = userName,
            email = email,
            password = password,
            firstName = firstName,
            lastName = lastName
        )
    }

    companion object {
        fun validate(request: CreateUserRequest): List<String> {
            val errors = mutableListOf<String>()
            require(request.userName.isNotBlank()) { errors.add("ユーザー名は必須です") }
            require(request.email.isNotBlank()) { errors.add("メールアドレスは必須です")}
            return errors
        }
    }
}

data class CreateUserParam(
    val userName: String,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)
