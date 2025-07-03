package com.ecmall.ec_mall.infra.membership

import com.ecmall.ec_mall.usecase.createUser.MembershipCreateUserQueryService
import com.ecmall.ec_mall.usecase.createUser.MembershipCreateUserQueryServiceDto
import com.ecmall.ec_mall.usecase.updateUser.MembershipUpdateQueryService
import com.ecmall.ec_mall.usecase.updateUser.MembershipUpdateQueryServiceDto
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@Component
class MembershipClient: MembershipCreateUserQueryService,MembershipUpdateQueryService {

    private val membershipBaseUrl = "http://localhost:3000/v1/create/member"
    private val logger = LoggerFactory.getLogger(MembershipClient::class.java)

    override fun fetchCreatedMember(
        userName: String,
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): MembershipCreateUserQueryServiceDto? {
        val url = "http://localhost:3000/v1/create/member"

        val requestBody = mapOf(
            "userName" to userName,
            "email" to email,
            "password" to password,
            "firstName" to firstName,
            "lastName" to lastName
        )

        logger.info("メンバーシップAPIリクエスト URI: {}", membershipBaseUrl)
        val restClient = RestClient.create()
        val result = restClient.post()
            .uri(url)
            .contentType(MediaType.APPLICATION_JSON)
            .body(requestBody)
            .retrieve()
            .body<MemberResponse>()
        if (result == null) return null

        return MembershipCreateUserQueryServiceDto(
            membershipId = result.membershipId
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
