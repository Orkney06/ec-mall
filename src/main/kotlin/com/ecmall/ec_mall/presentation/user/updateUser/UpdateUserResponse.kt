package com.ecmall.ec_mall.presentation.user.updateUser

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserResponse(
    val userId: String,
    val membershipId: String
)