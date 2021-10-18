package dao

import models.Usuario

class UsuarioDAO:GenericoDAO {
    override fun pegarUm(login: String): Any {
        val connection = ConnectionDAO()
        val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Usuario WHERE login = '${login}';""")
        var usuario : Usuario? = null
        while (resultSet?.next()!!) {
            usuario = Usuario(
                resultSet.getString("login"),
                resultSet.getString("senha"),
                resultSet.getString("email")
            )
        }
        resultSet.close()
        connection.close()
        return usuario!!
    }

    override fun pegarTodos(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun inserirUm(objeto: Any) {
        TODO("Not yet implemented")
    }

    override fun inserirVarios(lista: List<Any>) {
        TODO("Not yet implemented")
    }

    override fun atualizar(objeto: Any) {
        TODO("Not yet implemented")
    }

    override fun deletar(id: Int) {
        TODO("Not yet implemented")
    }
}