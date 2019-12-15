package org.microservices.master.restfulwebservices.service.impl

import org.microservices.master.restfulwebservices.domain.Post
import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.domain.input.NewPostForm
import org.microservices.master.restfulwebservices.exceptions.UserNotFoundException
import org.microservices.master.restfulwebservices.repository.UserMockRepository
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        private val userMockRepository: UserMockRepository
): UserService {
    override fun deleteUserById(userId: Int) {
        val userToDelete = getUserById(userId) ?: throw UserNotFoundException(userId)
        userMockRepository.delete(userToDelete)
    }

    override fun newPost(userId: Int, newPostForm: NewPostForm): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(user: User): User {
        return userMockRepository.save(user)
    }

    override fun getAllUsers(): List<User> {
        return userMockRepository.findAll()
    }

    override fun getUserById(id: Int): User? {
        return userMockRepository.findOne(id)
    }
}