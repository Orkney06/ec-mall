package com.ecmall.ec_mall.infra.repository

import com.ecmall.ec_mall.domain.user.AccountStatus
import com.ecmall.ec_mall.domain.user.User
import com.ecmall.ec_mall.domain.user.UserRepository
import com.ecmall.ec_mall.infra.rds.DatabaseConnector
import com.ecmall.ec_mall.infra.rds.ecmall.UserTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserExposedRepository(
    private val databaseConnector: DatabaseConnector
) : UserRepository {
    override fun insert(user: User) {
        databaseConnector.connect()
        transaction {
            addLogger(StdOutSqlLogger)
            UserTable.insert {
                it[id] = user.userId
                it[membershipId] = user.membershipId
                it[accountStatus] = user.accountStatus.toString()
            }
        }
    }

    override fun fetchUserByMembershipId(membershipId: String): User? {
        databaseConnector.connect()
        return transaction {
            addLogger(StdOutSqlLogger)
            UserTable.select (UserTable.id, UserTable.membershipId, UserTable.accountStatus )
                .where{ UserTable.membershipId eq membershipId }
                .singleOrNull()?.let { row ->
                User(
                    userId = row[UserTable.id].toString(),
                    membershipId = row[UserTable.membershipId],
                    accountStatus = AccountStatus.valueOf(row[UserTable.accountStatus])
                )
            }
        }
    }
}