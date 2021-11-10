package dao

import models.Review
import models.Usuario
import java.sql.Date

class ReviewDAO:GenericoDAO {
    override fun pegarUm(login: String): Review {
        TODO("Not yet implemented")
    }

    override fun pegarTodos(nome: String): List<Any> {
        val reviews = mutableListOf<Review>()
        try {
            val connection = ConnectionDAO()
            val id_ele = connection.executeQuery("""SELECT ID FROM Pop_Games.Elementos where nome = '${nome}""")
            val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Review where idElemento = ${id_ele}""")
            while(resultSet?.next()!!){
                reviews.add(
                    Review(
                        resultSet.getInt("idReview"),
                        resultSet.getString("review"),
                        resultSet.getInt("curtidas"),
                        resultSet.getDate("data"),
                        resultSet.getInt("idElemento"),
                        resultSet.getString("login")
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

    override fun deletar(nome: String) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            DELETE FROM Pop_Games.Review
            WHERE nome = ?;
            """.trimMargin())
        preparedStatement?.setString(1, nome)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }
}