package org.microservices.master.restfulwebservices.domain

import java.time.ZonedDateTime

data class ExceptionResponse(
        var timestamp: ZonedDateTime,

        var message: String,

        var details: String
) {
    constructor(): this(ZonedDateTime.now(), "dummy-message", "no additional details")
}