package ru.hetcho.kofuplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KofuPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<KofuPlaygroundApplication>(*args)
}
