package org.microservices.master.restfulwebservices.domain

import java.time.LocalDate

data class User(
        var id: Int?,

        val name: String,

        val birthDate: LocalDate
) {
    constructor(): this(0, "sample-name", LocalDate.now())
}