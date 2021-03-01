package ru.hetcho.kofuplayground.handlers

import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait

class Handler {

    suspend fun get(request: ServerRequest) = ok().bodyValueAndAwait("Hello, world!")
}