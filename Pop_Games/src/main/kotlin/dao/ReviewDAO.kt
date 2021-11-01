package dao

import models.Review
import models.Usuario

class ReviewDAO:GenericoDAO {
    override fun pegarUm(login: String): Review {
        val connection = ConnectionDAO()
        val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Review WHERE login = '${login}';""")
        var review : Review? = null
        while (resultSet?.next()!!) {
            review = Review(
                resultSet.getInt("idReview"),
                resultSet.getString("review"),
                resultSet.getString("curtidas"),
                resultSet.getDate("data"),
                resultSet.getInt("idElemento"),
                resultSet.getString("login")
            )
        }
        resultSet.close()
        connection.close()
        return review!!
    }

    override fun pegarTodos(): List<Any> {
        TODO("Not yet implemented")
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