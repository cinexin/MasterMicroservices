package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.exceptions.UserNotFoundException
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

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
    fun getUserById(@PathVariable("id") id: Int): User {
        return userService.getUserById(id) ?: throw UserNotFoundException(id)
    }

    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val savedUser =  userService.createUser(user)

        val newUserUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id)
                .toUri()
        return ResponseEntity.created(newUserUri).build()
    }

    @DeleteMapping("{id}")
    fun deleteUserById(@PathVariable("id") userId: Int): ResponseEntity<Any> {
        userService.deleteUserById(userId)
        return ResponseEntity.noContent().build()
    }
}