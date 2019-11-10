package org.microservices.master.restfulwebservices

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestfulWebservicesApplication

fun main(args: Array<String>) {
	runApplication<RestfulWebservicesApplication>(*args)
}
