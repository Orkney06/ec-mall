package com.ecmall.ec_mall.usecase.updateUser

import com.ecmall.ec_mall.domain.user.UserRepository
import com.ecmall.ec_mall.presentation.user.updateUser.UpdateUserParam
import org.springframework.stereotype.Component

@Component
class UpdateUserUseCase(
    private val membershipUpdateQueryService: MembershipUpdateQueryService,
    private val userRepository: UserRepository
) {
    fun execute(updateUserParam: UpdateUserParam): UpdateUserDto {
        val updateMember = membershipUpdateQueryService.updateMember(
            updateUserParam.membershipId,
            updateUserParam.userName,
            updateUserParam.email,
            updateUserParam.password,
            updateUserParam.firstName,
            updateUserParam.lastName
        )

        // ユーザーテーブルからIDを取得
        val user = userRepository.fetchUserByMembershipId(updateMember.membershipId)
            ?: throw UserNotFoundException("Membership ID '${updateMember.membershipId}' に紐づくユーザーが見つかりませんでした。")

        return UpdateUserDto(
            userId = user.userId,
            membershipId = updateMember.membershipId
        )
    }
}

class UserNotFoundException(message: String): RuntimeException(message)