package com.ecmall.ec_mall.infra.membership

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse(
    @SerialName("membershipId")
    val membershipId: String
)