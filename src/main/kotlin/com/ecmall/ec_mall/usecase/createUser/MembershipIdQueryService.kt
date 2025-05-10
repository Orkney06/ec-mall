package com.ecmall.ec_mall.usecase.createUser

data class MembershipCreateUserQueryServiceDto(
    val membershipId: String
)

interface MembershipCreateUserQueryService {
    fun fetchCreatedMember(
        userName: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): MembershipCreateUserQueryServiceDto
}