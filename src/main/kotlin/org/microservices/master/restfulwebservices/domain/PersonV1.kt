package org.microservices.master.restfulwebservices.domain

/**
 * This class helps us to understand versioning concepts
 */
data class PersonV1(
    val name: String
) {
    constructor(): this("sample-name")
}