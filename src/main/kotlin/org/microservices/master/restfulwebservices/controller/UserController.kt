package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UserController(
        private val userService: UserService
) {

    @GetMapping("")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable("id") id: Int): User? {
        return userService.getUserById(id)
    }
}