package org.microservices.master.restfulwebservices.domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.hateoas.Link
import org.springframework.hateoas.ResourceSupport
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel(description = "All details about the user")
@Entity
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,

        @ApiModelProperty(notes = "Names should be at least 2 characters long")
        @field:Size(min = 2, message = "Name should have at least 2 characters")
        var name: String,

        @ApiModelProperty(notes = "Birth date should be in the past")
        @field:Past(message = "A birth date cannot occur in the future")
        var birthDate: LocalDate,

        @OneToMany(mappedBy = "user")
        var posts: MutableList<Post>

): ResourceSupport(){
        constructor(): this(null, "sample-name", LocalDate.now(), mutableListOf())

        constructor(id: Int, name: String, birthDate: LocalDate): this(id, name, birthDate, mutableListOf())

        constructor(name: String, birthDate: LocalDate): this(null, name, birthDate, mutableListOf())

        override fun toString(): String {
                return "$name - ${posts.map { it.description }}"
        }
}