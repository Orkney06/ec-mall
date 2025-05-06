package com.ecmall.ec_mall.infra.membership

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MemberResponse(
    @SerialName("membership_id")
    val membershipId: String
)