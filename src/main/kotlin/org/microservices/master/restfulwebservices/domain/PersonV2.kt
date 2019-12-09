package org.microservices.master.restfulwebservices.domain

/**
 * This class helps us to understand versioning concepts
 */
data class PersonV2(
    val name: Name
) {
    constructor(): this(Name())
}