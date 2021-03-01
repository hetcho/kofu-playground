package ru.hetcho.kofuplayground

import org.springframework.web.reactive.function.server.coRouter
import ru.hetcho.kofuplayground.handlers.Handler
import ru.hetcho.kofuplayground.handlers.UserHandler

fun routes(handler: Handler) = coRouter {
    GET("/", handler::get)
}

fun userRoutes(handler: UserHandler) = coRouter {
    GET("/users", handler::findAll)
    GET("/users/{id}", handler::findById)
}