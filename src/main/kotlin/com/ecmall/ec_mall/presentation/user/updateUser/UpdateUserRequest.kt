package com.ecmall.ec_mall.presentation.user.updateUser

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserRequest(
    val membershipId: String,
    val userName: String?,
    val email: String?,
    val password: String?,
    val firstName: String?,
    val lastName: String?
) {
    fun hasAnyValue(): Boolean {
        return userName != null ||
                email != null ||
                password != null ||
                firstName != null ||
                lastName != null
    }

    fun toParam(): UpdateUserParam {
        return UpdateUserParam(
            membershipId = membershipId,
            userName = userName,
            email = email,
            password = password,
            firstName = firstName,
            lastName = lastName
        )
    }
}

data class UpdateUserParam(
    val membershipId: String,
    val userName: String?,
    val email: String?,
    val password: String?,
    val firstName: String?,
    val lastName: String?
)