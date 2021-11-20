package plugins

import com.google.gson.Gson
import dao.UsuarioDAO
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        get ("/login") {
            val usuarioDAO = UsuarioDAO()
            var user = usuarioDAO.pegarUm("teste")
            var gson = Gson()
            var jsonString = gson.toJson(user)
            call.respond(jsonString)
        }
        
    }
}