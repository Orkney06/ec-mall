package com.ecmall.ec_mall.infra.repository

import com.ecmall.ec_mall.domain.user.User
import com.ecmall.ec_mall.domain.user.UserRepository
import com.ecmall.ec_mall.infra.rds.DatabaseConnector
import com.ecmall.ec_mall.infra.rds.ecmall.UserTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserExposedRepository(
    private val databaseConnector: DatabaseConnector
): UserRepository{
    override fun insert(user: User) {
        databaseConnector.connect()
        transaction {
            UserTable.insert {
                it[id] = user.userId
                it[membershipId] = user.membershipId
                it[accountStatus] = user.accountStatus.toString()
            }
        }
    }
}