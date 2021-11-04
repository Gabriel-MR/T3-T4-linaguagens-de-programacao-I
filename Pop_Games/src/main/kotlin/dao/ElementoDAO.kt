package dao

import models.Elementos
import models.Usuario

class ElementoDAO:GenericoDAO {
    override fun pegarUm(nome: String): Elementos {
        val connection = ConnectionDAO()
        val resultSet = connection.executeQuery("""SELECT * FROM Pop_Games.Elementos WHERE nome = '${nome}';""")
        var elemento : Elementos? = null
        while (resultSet?.next()!!) {
            elemento = Elementos(
                resultSet.getInt("idElemento"),
                resultSet.getString("categoria"),
                resultSet.getString("descricao"),
                resultSet.getString("nome"),
                resultSet.getString("url")
            )
        }
        resultSet.close()
        connection.close()
        return elemento!!
    }

    override fun inserirUm(objeto: Any) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            INSERT INTO Pop_Games.Elementos 
            values (?, ?, ?, ?, ?);
            """.trimMargin())
        val novo_elemento = objeto as Elementos
        preparedStatement?.setInt(1, novo_elemento.id)
        preparedStatement?.setString(2, novo_elemento.categoria)
        preparedStatement?.setString(3, novo_elemento.descricao)
        preparedStatement?.setString(4, novo_elemento.nome)
        preparedStatement?.setString(5, novo_elemento.url)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }

    override fun pegarTodos(): List<Any> {
        TODO("Not yet implemented")
    }

    override fun inserirVarios(lista: List<Any>) {
        TODO("Not yet implemented")
    }

    override fun atualizar(objeto: Any) {
        TODO("Not yet implemented")
    }

    override fun deletar(nome: String) {
        val connection = ConnectionDAO()
        val preparedStatement = connection.getPreparedStatement("""
            DELETE FROM Pop_Games.Elementos
            WHERE nome = ?;
            """.trimMargin())
        preparedStatement?.setString(1, nome)
        preparedStatement?.executeUpdate()
        connection.commit()
        connection.close()
    }
}