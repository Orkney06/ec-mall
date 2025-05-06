package com.ecmall.ec_mall.domain.user

import java.util.UUID

data class User(
    val userId: String,
    val membershipId: String,
    val accountStatus: AccountStatus
) {
    companion object{
        private fun generateUserId(): String {
            return UUID.randomUUID().toString()
        }

        fun create(membershipId: String): User {
            return User(
                userId = generateUserId(),
                membershipId = membershipId,
                accountStatus = AccountStatus.ACTIVE
            )
        }
    }
}

enum class AccountStatus {
    ACTIVE, INACTIVE, PENDING
}
