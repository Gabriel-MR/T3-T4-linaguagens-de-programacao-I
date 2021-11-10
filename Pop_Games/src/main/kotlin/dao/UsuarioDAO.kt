package dao

import models.Usuario

class UsuarioDAO:GenericoDAO {
    override fun pegarUm(login: String): Usuario {
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

    override fun inserirUm(objeto: Any) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            INSERT INTO Pop_Games.Usuario 
            values (?, ?, ?);
            """.trimMargin())
        val novo_usuario = objeto as Usuario
        preparedStatement?.setString(1, novo_usuario.login)
        preparedStatement?.setString(2, novo_usuario.senha)
        preparedStatement?.setString(3, novo_usuario.email)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }

    override fun pegarTodos(nome: String): List<Any> {
        TODO("Not yet implemented")
    }

    override fun inserirVarios(lista: List<Any>) {
        TODO("Not yet implemented")
    }

    override fun atualizar(objeto: Any) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            UPDATE Pop_Games.Usuario 
            SET senha = ?
            WHERE login = ?;
            """.trimMargin())
        val novo_usuario = objeto as Usuario
        preparedStatement?.setString(1, novo_usuario.senha)
        preparedStatement?.setString(2, novo_usuario.login)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }

    override fun deletar(login: String) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            DELETE FROM Pop_Games.Usuario
            WHERE login = ?;
            """.trimMargin())
        preparedStatement?.setString(1, login)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }
}