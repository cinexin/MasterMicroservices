package org.microservices.master.restfulwebservices.service

import org.microservices.master.restfulwebservices.domain.Post
import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.domain.input.NewPostForm

interface UserService {

    fun createUser(user: User): User

    fun getAllUsers(): List<User>

    fun getUserById(id: Int): User?

    fun deleteUserById(userId: Int)

    fun newPost(userId: Int,
                newPostForm: NewPostForm): Post
}