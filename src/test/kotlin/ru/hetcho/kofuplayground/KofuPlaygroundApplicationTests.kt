package ru.hetcho.kofuplayground

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class KofuPlaygroundApplicationTests {

    private val client = WebTestClient.bindToServer().baseUrl("http://localhost:8181").build()

    private lateinit var context: ConfigurableApplicationContext

    @BeforeAll
    fun beforeAll() {
        context = app.run(profiles = "test")
    }

    @Test
    fun `Request HTML endpoint`() {
        client.get().uri("/").exchange().expectStatus().is2xxSuccessful
    }

    @AfterAll
    fun afterAll() {
        context.close()
    }
}
