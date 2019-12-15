package org.microservices.master.restfulwebservices.service.impl

import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.repository.UserJPARepository
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.stereotype.Service

@Service
class UserJPAServiceImpl(private val userJPARepository: UserJPARepository): UserService {

    override fun createUser(user: User): User {
        return userJPARepository.save(user)
    }

    override fun getAllUsers(): List<User> {
        return userJPARepository.findAll()
    }

    override fun getUserById(id: Int): User? {
        return userJPARepository.findById(id).orElse(null)
    }

    override fun deleteUserById(userId: Int) {
        return userJPARepository.deleteById(userId)
    }
}