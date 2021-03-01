package ru.hetcho.kofuplayground.handlers

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import ru.hetcho.kofuplayground.entities.User

class UserHandler {

    suspend fun findAll(request: ServerRequest) = ok().bodyValueAndAwait(listOf(User("name", "surname"), User("name1", "surname1"), User("name2", "surname2")))
    suspend fun findById(request: ServerRequest) = ok().bodyValueAndAwait(User("name", "surname").apply { id = request.pathVariable("id").toLong() })
}