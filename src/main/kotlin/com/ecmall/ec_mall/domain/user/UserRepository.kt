package com.ecmall.ec_mall.domain.user

interface UserRepository {
    fun insert(user: User)
    fun fetchUserByMembershipId(membershipId: String): User?
}