package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.exceptions.UserNotFoundException
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

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
    fun getUserById(@PathVariable("id") id: Int): EntityModel<User> {
        val user = userService.getUserById(id) ?: throw UserNotFoundException(id)

        // HATEOAS
        val model = EntityModel(user)
        val linkTo = linkTo(methodOn(this::class.java).getAllUsers())
        model.add(linkTo.withRel("all-users"))

        return model
    }

    @PostMapping("")
    fun createUser(@Valid @RequestBody user: User): ResponseEntity<User> {
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