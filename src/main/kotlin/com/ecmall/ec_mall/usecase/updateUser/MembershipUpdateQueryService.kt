package com.ecmall.ec_mall.usecase.updateUser

data class MembershipUpdateQueryServiceDto(
    val membershipId: String
)

interface MembershipUpdateQueryService {
    fun updateMember(
        membershipId: String,
        userName: String?,
        email: String?,
        password: String?,
        firstName: String?,
        lastName: String?
    ): MembershipUpdateQueryServiceDto
}