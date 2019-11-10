package org.microservices.master.restfulwebservices.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @RequestMapping(method = [RequestMethod.GET], path = ["/hello-world"])
    fun helloWorld(): String {
        return "Hello World!"
    }
}