package org.microservices.master.restfulwebservices.repository

import org.microservices.master.restfulwebservices.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJPARepository: JpaRepository<User, Int>