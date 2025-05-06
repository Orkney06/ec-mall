package com.ecmall.ec_mall.usecase.createUser

data class MembershipIdDto(
    val membershipId: String
)

interface MembershipIdQueryService {
    fun fetchCreatedMember(
        userName: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): MembershipIdDto
}