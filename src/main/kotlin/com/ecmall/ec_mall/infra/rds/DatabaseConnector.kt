package com.ecmall.ec_mall.infra.rds

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class DatabaseConnector {
    @Value("\${spring.datasource.url}")
    private lateinit var dbUrl: String

    @Value("\${spring.datasource.driver-class-name}")
    private lateinit var dbDriver: String

    @Value("\${spring.datasource.username}")
    private lateinit var dbUser: String

    @Value("\${spring.datasource.password}")
    private lateinit var dbPassword: String

    fun connect() {
        Database.connect(
            url = dbUrl,
            driver = dbDriver,
            user = dbUser,
            password = dbPassword
        )
    }
}