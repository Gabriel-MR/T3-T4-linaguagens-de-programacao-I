import models.Usuario

fun main(args: Array<String>) {
    val usuarioDAO = dao.UsuarioDAO()
    val usuario = usuarioDAO.pegarUm("teste2")
    println(usuario.login)
    //usuarioDAO.inserirUm(Usuario("teste3", "teste3", "teste3@gmail.com"))
    //usuarioDAO.atualizar(Usuario("teste3", "123", "teste3@gmail.com"))
    //usuarioDAO.deletar("teste3")
}