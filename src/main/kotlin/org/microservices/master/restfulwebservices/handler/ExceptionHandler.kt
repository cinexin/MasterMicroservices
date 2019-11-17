package org.microservices.master.restfulwebservices.handler

import org.microservices.master.restfulwebservices.domain.ExceptionResponse
import org.microservices.master.restfulwebservices.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.ZonedDateTime


@ControllerAdvice
@RestController
class BaseExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(value=[Exception::class])
    fun basicExceptionHandler(ex: Exception): ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(ZonedDateTime.now(), ex.message ?: "no message", ex.localizedMessage)
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(value=[UserNotFoundException::class])
    fun userNotFoundExceptionHandler(ex: UserNotFoundException):ResponseEntity<ExceptionResponse> {
        val exceptionResponse = ExceptionResponse(ZonedDateTime.now(), "User not found", ex.message ?: "no message")
        return ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND)
    }

}