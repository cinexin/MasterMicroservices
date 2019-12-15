package org.microservices.master.restfulwebservices.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,

        var description: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @get:JsonIgnore
        var user: User
) {
    constructor(): this(null, "sample-description", User())
    constructor(description: String, user: User): this(null, description, user)
}