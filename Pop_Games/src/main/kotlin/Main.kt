import models.Review
import java.sql.Date
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.HttpMethod.Companion.Options
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    /*
    /// Funções para tabela Usuario
    val usuarioDAO = dao.UsuarioDAO()
    usuarioDAO.inserirUm(Usuario("teste", "teste", "teste@gmail.com"))
    val peg = usuarioDAO.pegarUm("teste")
    usuarioDAO.atualizar(Usuario("teste", "12345", "teste@gmail.com"))
    usuarioDAO.deletar("teste")
    */

    /*
    /// Funções para tabela Elemento
    val elementoDAO = dao.ElementoDAO()
    val peg = elementoDAO.pegarUm("007")
    elementoDAO.inserirUm(Elementos(0, "comédia", "legal", "Simpsons", "Simpsons.com.br"))
    elementoDAO.deletar("007")
    */

    /*
    /// Funções para tabela Review
    val reviewDAO = dao.ReviewDAO()
    */

    embeddedServer(Netty, port = 8080, host = "localhost") {
        install(CORS) {
            method(HttpMethod.Options)
            anyHost()
        }
        routing {
            get ("/") {
                call.respondText("Hello, world!")
            }
        }
    }.start(wait = true)
}
