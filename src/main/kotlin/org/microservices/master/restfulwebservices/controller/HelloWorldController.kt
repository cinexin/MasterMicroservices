package org.microservices.master.restfulwebservices.controller

import org.microservices.master.restfulwebservices.domain.HelloWorldBean
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hello-world")
class HelloWorldController(
        private val messageSource: MessageSource
) {


    @GetMapping
    fun helloWorld(): String {
        return "Hello World!"
    }

    @GetMapping("/who/{name}")
    fun helloWorldBean(@PathVariable("name") name: String): HelloWorldBean {
        return HelloWorldBean("Hello World, $name!")
    }

    @GetMapping("/internationalized")
    fun helloWorldInternationalized(): String {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale())
    }
}