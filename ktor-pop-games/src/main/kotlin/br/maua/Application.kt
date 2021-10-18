package br.maua

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import br.maua.plugins.*
import io.ktor.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        routing{
            get("/"){
                //html
            }
        }
        configureRouting()
    }.start(wait = true)
}
