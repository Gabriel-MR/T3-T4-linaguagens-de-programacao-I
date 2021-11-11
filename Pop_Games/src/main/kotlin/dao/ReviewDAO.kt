package dao

import models.Review
import java.sql.Date

class ReviewDAO:GenericoDAO {
    override fun pegarUm(login: String): Review {
        TODO("Not yet implemented")
    }

    override fun pegarTodos(nome: String): List<Any> {
        val reviews = mutableListOf<Review>()
        try {
            val connection = ConnectionDAO()
            val elementoDAO = dao.ElementoDAO()
            val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Review WHERE idElemento = ${elementoDAO.pegarUm(nome).id}""")
            while(resultSet?.next()!!){
                reviews.add(
                    Review(
                        resultSet.getInt("id"),
                        resultSet.getString("review"),
                        resultSet.getDate("data"),
                        resultSet.getString("login"),
                        resultSet.getInt("idElemento")
                    )
                )
            }
            connection.close()
        }

        catch (exception:Exception){
            exception.printStackTrace()
        }

        return reviews
    }

    override fun inserirUm(objeto: Any) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            INSERT INTO Pop_Games.Review 
            values (?, ?, ?, ?, ?);
            """.trimMargin())
        val novo_review = objeto as Review
        preparedStatement?.setInt(1, novo_review.id)
        preparedStatement?.setString(2, novo_review.review)
        preparedStatement?.setDate(3, novo_review.data as Date?)
        preparedStatement?.setString(4, novo_review.login)
        preparedStatement?.setInt(5, novo_review.idElemento)
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
        preparedStatement?.setInt(3, novo_review.id)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }

    override fun deletar(login: String) {
        TODO("Not yet implemented")
    }

    fun deletar(objeto: Any) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            DELETE FROM Pop_Games.Review
            WHERE review = ? AND data = ? AND id = ?;
            """.trimMargin())
        val deletar = objeto as Review
        preparedStatement?.setString(1, deletar.review)
        preparedStatement?.setDate(2, deletar.data)
        preparedStatement?.setInt(3, deletar.id)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }
}