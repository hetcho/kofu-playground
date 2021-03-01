package ru.hetcho.kofuplayground

import org.springframework.boot.logging.LogLevel
import org.springframework.fu.kofu.configuration
import org.springframework.fu.kofu.reactiveWebApplication
import org.springframework.fu.kofu.webflux.webFlux
import ru.hetcho.kofuplayground.handlers.Handler

val app = reactiveWebApplication {
    logging { level = LogLevel.DEBUG }
    enable(webConfig)
}

val webConfig = configuration {
    beans {
        bean<Handler>()
        bean(::routes)
    }
    webFlux {
        port = if (profiles.contains("test")) 8181 else 8080
    }
}

fun main(args: Array<String>) {
    app.run(args)
}
