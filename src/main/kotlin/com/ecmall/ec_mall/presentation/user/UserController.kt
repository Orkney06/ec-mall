package com.ecmall.ec_mall.presentation.user

import com.ecmall.ec_mall.presentation.user.createUser.CreateUserRequest
import com.ecmall.ec_mall.presentation.user.createUser.CreateUserResponse
import com.ecmall.ec_mall.usecase.createUser.CreateUserUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController(
    private val createUserUseCase: CreateUserUseCase
) {
    /**
     * API01 ユーザー作成
     */
    @PostMapping("/user")
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): ResponseEntity<CreateUserResponse> {
        val createUserDto = createUserUseCase.execute(createUserRequest.validate())
        val createUserResponse = CreateUserResponse(
            id = createUserDto.id,
            membershipId = createUserDto.memberShipId
        )
        return ResponseEntity.ok(createUserResponse)
    }
}