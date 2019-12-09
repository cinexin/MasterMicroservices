package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.UserWithFilters
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users/with-filters")
class UserWithFiltersController {

    @GetMapping("")
    fun retrieveUserWithFilters(): UserWithFilters {
        return UserWithFilters()
    }

    @GetMapping("/list")
    fun retrieveUsersWithFiltersList(): List<UserWithFilters> {
        return UserWithFilters.getSampleList()
    }
}