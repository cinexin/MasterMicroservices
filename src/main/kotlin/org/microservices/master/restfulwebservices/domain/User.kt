package org.microservices.master.restfulwebservices.domain

import java.time.LocalDate
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class User(
        var id: Int?,

        @field:Size(min = 2, message = "Name should have at least 2 characters")
        val name: String,

        @field:Past(message = "A birth date cannot occur in the future")
        val birthDate: LocalDate
) {
    constructor(): this(0, "sample-name", LocalDate.now())
}