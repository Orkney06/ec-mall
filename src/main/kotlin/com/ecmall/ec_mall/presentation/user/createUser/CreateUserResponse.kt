package com.ecmall.ec_mall.presentation.user.createUser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateUserResponse (
    @SerialName("user_id") val id: String,
    @SerialName("membership_id") val membershipId: String,
)
