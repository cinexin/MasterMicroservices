package org.microservices.master.restfulwebservices.service

import org.microservices.master.restfulwebservices.domain.enums.UserServiceMode
import org.microservices.master.restfulwebservices.service.impl.UserJPAServiceImpl
import org.microservices.master.restfulwebservices.service.impl.UserServiceImpl
import org.springframework.stereotype.Component

@Component
class UserServiceFactory(private val userServiceImpl: UserServiceImpl,
                         private val userJPAServiceImpl: UserJPAServiceImpl) {

    fun forServiceMode(serviceMode: UserServiceMode): UserService {
        return when(serviceMode) {
            UserServiceMode.STATIC -> userServiceImpl
            UserServiceMode.JPA -> userJPAServiceImpl
        }
    }

}