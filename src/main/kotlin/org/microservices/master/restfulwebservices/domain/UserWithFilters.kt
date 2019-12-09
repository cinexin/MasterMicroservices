package org.microservices.master.restfulwebservices.domain

import com.fasterxml.jackson.annotation.JsonIgnore

data class UserWithFilters(
        val id: String,

        val name: String,

        @JsonIgnore
        val password: String
) {
    constructor(): this("sample-id", "sample-name", "sample-password")

    companion object {
        fun getSampleList(): List<UserWithFilters> {
            return listOf(
                    UserWithFilters("id-1", "name-1", "password-1"),
                    UserWithFilters("id-2", "name-2", "password-2"),
                    UserWithFilters("id-3", "name-3", "password-3")
            )
        }
    }
}