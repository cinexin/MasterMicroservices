package org.microservices.master.restfulwebservices.domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.springframework.hateoas.ResourceSupport
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Past
import javax.validation.constraints.Size

@ApiModel(description = "All details about the user")
@Entity
data class User(
        @Id
        @GeneratedValue
        var id: Int?,

        @ApiModelProperty(notes = "Names should be at least 2 characters long")
        @field:Size(min = 2, message = "Name should have at least 2 characters")
        var name: String,

        @ApiModelProperty(notes = "Birth date should be in the past")
        @field:Past(message = "A birth date cannot occur in the future")
        var birthDate: LocalDate

): ResourceSupport(){
    constructor(): this(0, "sample-name", LocalDate.now())
}