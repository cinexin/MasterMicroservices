package org.microservices.master.restfulwebservices.domain

import java.time.LocalDate
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class User(
        var id: Int?,

        @field:Size(min = 2)
        val name: String,

        @field:Past
        val birthDate: LocalDate
) {
    constructor(): this(0, "sample-name", LocalDate.now())
}