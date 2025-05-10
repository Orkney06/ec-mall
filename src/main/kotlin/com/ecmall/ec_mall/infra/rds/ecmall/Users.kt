package com.ecmall.ec_mall.infra.rds.ecmall

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object UserTable : Table("users") {
    val id = varchar("id", 36)
    val membershipId = varchar("membership_id", 255)
    val accountStatus = varchar("account_status", 50)
    val registrationDate = datetime("registration_date")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}