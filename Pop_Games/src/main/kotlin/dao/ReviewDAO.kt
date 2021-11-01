package dao

import models.Review
import models.Usuario
import java.sql.Date

class ReviewDAO:GenericoDAO {
    override fun pegarUm(login: String): Review {
        val connection = ConnectionDAO()
        val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Review WHERE login = '${login}';""")
        var review : Review? = null
        while (resultSet?.next()!!) {
            review = Review(
                resultSet.getInt("idReview"),
                resultSet.getString("review"),
                resultSet.getInt("curtidas"),
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
            INSERT INTO Pop_Games.Review 
            values (?, ?, ?, ?, ?);
            """.trimMargin())
        val novo_review = objeto as Review
        preparedStatement?.setString(1, novo_review.review)
        preparedStatement?.setInt(2, novo_review.curtidas)
        preparedStatement?.setDate(3, novo_review.data as Date?)
        preparedStatement?.setInt(4, novo_review.idElemento)
        preparedStatement?.setString(5, novo_review.login)
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
            UPDATE Pop_Games.Review 
            SET review = ?
            WHERE login = ?
            AND idReview = ?;
            """.trimMargin())
        val novo_review = objeto as Review
        preparedStatement?.setString(1, novo_review.review)
        preparedStatement?.setString(2, novo_review.login)
        preparedStatement?.setInt(3, novo_review.idReview)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }

    override fun deletar(login: String) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            DELETE FROM Pop_Games.Review
            WHERE login = ?;
            """.trimMargin())
        preparedStatement?.setString(1, login)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }
}