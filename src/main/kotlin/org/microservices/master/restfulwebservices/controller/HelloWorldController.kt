package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.HelloWorldBean
import org.springframework.web.bind.annotation.*

@RestController
class HelloWorldController {

    @RequestMapping(method = [RequestMethod.GET], path = ["/hello-world"])
    fun helloWorld(): String {
        return "Hello World!"
    }

    @GetMapping("/hello-world-bean/who/{name}")
    fun helloWorldBean(@PathVariable("name") name: String): HelloWorldBean {
        return HelloWorldBean("Hello World, $name!")
    }
}