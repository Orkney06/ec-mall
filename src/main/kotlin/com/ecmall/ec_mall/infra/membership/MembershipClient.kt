package com.ecmall.ec_mall.infra.membership

import com.ecmall.ec_mall.usecase.createUser.MembershipIdDto
import com.ecmall.ec_mall.usecase.createUser.MembershipIdQueryService
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component

@Component
class MembershipClient : MembershipIdQueryService {
    override fun fetchCreatedMember(
        userName: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): MembershipIdDto {
        val responseJson = """
            {
                "membership_id":"member_1234"
            }
        """.trimIndent()

        val memberResponse = Json.decodeFromString<MemberResponse>(responseJson)
        return MembershipIdDto(
            membershipId = memberResponse.membershipId
        )
    }
}