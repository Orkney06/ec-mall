package com.ecmall.ec_mall.infra.membership

import com.ecmall.ec_mall.usecase.createUser.MembershipCreateUserQueryService
import com.ecmall.ec_mall.usecase.createUser.MembershipCreateUserQueryServiceDto
import com.ecmall.ec_mall.usecase.updateUser.MembershipUpdateQueryService
import com.ecmall.ec_mall.usecase.updateUser.MembershipUpdateQueryServiceDto
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component

@Component
class MembershipClient : MembershipCreateUserQueryService,MembershipUpdateQueryService {
    override fun fetchCreatedMember(
        userName: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): MembershipCreateUserQueryServiceDto {
        val responseJson = """
            {
                "membershipId":"member_1234"
            }
        """.trimIndent()

        val memberResponse = Json.decodeFromString<MemberResponse>(responseJson)
        return MembershipCreateUserQueryServiceDto(
            membershipId = memberResponse.membershipId
        )
    }

    override fun updateMember(
        membershipId: String,
        userName: String?,
        email: String?,
        password: String?,
        firstName: String?,
        lastName: String?
    ): MembershipUpdateQueryServiceDto {
        val responseJson = """
            {
                "membershipId":"user010"
            }
        """.trimIndent()

        val memberResponse = Json.decodeFromString<MemberResponse>(responseJson)
        return MembershipUpdateQueryServiceDto(
            membershipId = memberResponse.membershipId
        )
    }
}