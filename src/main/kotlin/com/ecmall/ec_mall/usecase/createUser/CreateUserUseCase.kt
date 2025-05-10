package com.ecmall.ec_mall.usecase.createUser

import com.ecmall.ec_mall.domain.user.User
import com.ecmall.ec_mall.domain.user.UserRepository
import com.ecmall.ec_mall.presentation.user.createUser.CreateUserParam
import org.springframework.stereotype.Component

@Component
class CreateUserUseCase(
    private val membershipCreateUserQueryService: MembershipCreateUserQueryService,
    private val userRepository: UserRepository
) {
    fun execute(createUserParam: CreateUserParam): CreateUserDto {
        // 会員情報を送信して会員IDを取得
        val membershipId = membershipCreateUserQueryService.fetchCreatedMember(
            createUserParam.userName,
            createUserParam.email,
            createUserParam.password,
            createUserParam.firstName,
            createUserParam.lastName
        )

        val createdUser = User.create(membershipId = membershipId.membershipId)

        userRepository.insert(createdUser)

        return CreateUserDto(
            id = createdUser.userId,
            memberShipId = createdUser.membershipId
        )
    }
}
