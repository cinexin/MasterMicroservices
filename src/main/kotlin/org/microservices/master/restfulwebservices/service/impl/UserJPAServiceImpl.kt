package org.microservices.master.restfulwebservices.service.impl

import org.microservices.master.restfulwebservices.domain.Post
import org.microservices.master.restfulwebservices.domain.User
import org.microservices.master.restfulwebservices.domain.input.NewPostForm
import org.microservices.master.restfulwebservices.exceptions.UserNotFoundException
import org.microservices.master.restfulwebservices.repository.PostJPARepository
import org.microservices.master.restfulwebservices.repository.UserJPARepository
import org.microservices.master.restfulwebservices.service.UserService
import org.springframework.stereotype.Service

@Service
class UserJPAServiceImpl(private val userJPARepository: UserJPARepository,
                         private val postJPARepository: PostJPARepository): UserService {

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

    override fun newPost(userId: Int, newPostForm: NewPostForm): Post {
        val user = getUserById(userId) ?: throw UserNotFoundException(userId)
        val newPost = Post(newPostForm.description, user)
        postJPARepository.save(newPost)
        user.posts.add(newPost)
        userJPARepository.save(user)

        return newPost
    }
}