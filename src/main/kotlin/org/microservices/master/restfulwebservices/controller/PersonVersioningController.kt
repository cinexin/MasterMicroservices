package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.Name
import org.microservices.master.restfulwebservices.domain.PersonV1
import org.microservices.master.restfulwebservices.domain.PersonV2
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonVersioningController {

    /**
     * URI versioning
     */
    @GetMapping("/v1/sample")
    fun getSamplePersonV1(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    /**
     * URI versioning
     */
    @GetMapping("/v2/sample")
    fun getSamplePersonV2(): PersonV2 {
        return PersonV2(Name("Bob", "Charlie"))
    }

    /**
     * Param versioning
     */
    @GetMapping(value = ["/sample/param"], params = ["version=1"])
    fun getSamplePersonParamV1(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    /**
     * Param versioning
     */
    @GetMapping(value = ["/sample/param"], params = ["version=2"])
    fun getSamplePersonParamV2(): PersonV2 {
        return PersonV2(Name("Bob", "Charlie"))
    }

    /**
     * Custom header versioning
     */
    @GetMapping(value = ["/sample/header"], headers = ["X-API-VERSION=1"])
    fun getSamplePersonHeaderV1(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    /**
     * Custom header versioning
     */
    @GetMapping(value = ["/sample/header"], headers = ["X-API-VERSION=2"])
    fun getSamplePersonHeaderV2(): PersonV2 {
        return PersonV2(Name("Bob", "Charlie"))
    }

    /**
     * Accept (header) versioning
     * aka MIME-Type versioning
     */
    @GetMapping(value = ["/sample/produces-header"], produces = ["application/vnd.company.app-v1+json"])
    fun getSamplePersonProducesHeaderV1(): PersonV1 {
        return PersonV1("Bob Charlie")
    }

    /**
     * Accept (header) versioning
     * aka MIME-Type versioning
     */
    @GetMapping(value = ["/sample/produces-header"], produces = ["application/vnd.company.app-v2+json"])
    fun getSamplePersonProducesHeaderV2(): PersonV2 {
        return PersonV2(Name("Bob", "Charlie"))
    }
}