package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.UserWithFilters
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("users/with-filters")
class UserWithFiltersController {

    // UserWithFilters -> id, name
    @GetMapping("")
    fun retrieveUserWithFilters(): MappingJacksonValue {
        return UserWithFilters.toDynaFilterMapping(UserWithFilters())
    }

    // UserWithFilters ->  name
    @GetMapping("/list")
    fun retrieveUsersWithFiltersList(): MappingJacksonValue {
        val userWithFiltersList = UserWithFilters.getSampleList()
        return UserWithFilters.toDynaFilterMapping(userWithFiltersList)
    }
}