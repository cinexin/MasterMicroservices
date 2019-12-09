package org.microservices.master.restfulwebservices.domain

data class Name(
        val firstName: String,
        val lastName: String
) {
    constructor(): this("sample-first-name", "sample-last-name")
}