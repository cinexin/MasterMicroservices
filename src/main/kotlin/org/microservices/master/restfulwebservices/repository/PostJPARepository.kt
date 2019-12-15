package org.microservices.master.restfulwebservices.repository

import org.microservices.master.restfulwebservices.domain.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostJPARepository: JpaRepository<Post, Int>