package org.microservices.master.restfulwebservices.repository

import org.microservices.master.restfulwebservices.domain.User
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserMockRepository {

    private val users = arrayListOf<User>()

    init {
        users.add(User(1, "Adam", LocalDate.now()))
        users.add(User(2, "Eve", LocalDate.now()))
        users.add(User(3, "Jack", LocalDate.now()))
    }

    fun findAll(): List<User> {
        return users
    }

    fun save(user: User): User {
        user.id = user.id ?: users.count() + 1
        users.add(user)
        return user
    }

    fun findOne(id: Int): User? {
        return users.firstOrNull { user -> user.id == id }
    }

}