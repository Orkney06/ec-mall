package com.ecmall.ec_mall.infra.repository

import com.ecmall.ec_mall.domain.user.User
import com.ecmall.ec_mall.domain.user.UserRepository
import com.ecmall.ec_mall.infra.rds.DatabaseConnector
import org.springframework.stereotype.Repository

@Repository
class UserExposedRepository(
    private val databaseConnector: DatabaseConnector
): UserRepository{
    override fun insert(user: User) {
        databaseConnector.connect()
    }
}