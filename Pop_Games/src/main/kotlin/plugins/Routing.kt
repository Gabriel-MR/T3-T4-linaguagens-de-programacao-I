package plugins

import com.google.gson.Gson
import dao.UsuarioDAO
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import java.net.URL

fun Application.configureRouting() {
    routing {
        get ("/login") {
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }

        get ("/register") {
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }

        get ("/userpage") {
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }

        get ("/lerreview") {
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }

        get ("/escreverreview") {
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }


    }
}