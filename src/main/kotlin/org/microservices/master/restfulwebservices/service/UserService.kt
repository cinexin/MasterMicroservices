package org.microservices.master.restfulwebservices.service

import org.microservices.master.restfulwebservices.domain.User

interface UserService {

    fun createUser(user: User): User

    fun getAllUsers(): List<User>

    fun getUserById(id: Int): User?

    fun deleteUserById(userId: Int)
}