package ru.hetcho.kofuplayground

import org.springframework.web.reactive.function.server.coRouter
import ru.hetcho.kofuplayground.handlers.Handler

fun routes(handler: Handler) = coRouter {
    GET("/", handler::get)
}