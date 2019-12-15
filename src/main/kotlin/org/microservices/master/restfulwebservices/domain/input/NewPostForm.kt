package org.microservices.master.restfulwebservices.domain.input

import javax.validation.constraints.NotEmpty

data class NewPostForm(
        @field:NotEmpty
        val description: String
) {
    constructor(): this("sample-post-description")
}