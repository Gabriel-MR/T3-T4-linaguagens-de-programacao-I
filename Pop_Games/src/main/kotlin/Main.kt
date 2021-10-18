import models.Usuario
import java.sql.DriverManager

fun main(args: Array<String>) {
    // Conexão com o banco
    val connection = DriverManager.getConnection(shared.SharedPaths.STRING_CONEXAO_JDBC)
    // Caminho para realizar queries
    val sqlStatement = connection.createStatement()
    // Executa a query
    val resultSet = sqlStatement.executeQuery("SELECT * FROM Pop_Games.Usuario;")
    // Intera pelos resultados obtidos
    while (resultSet.next()){
        val usuario = Usuario(
            resultSet.getString("login"),
            resultSet.getString("senha"),
            resultSet.getString("email")
        )
        println("Produto Encontrado: ${usuario}")
    }
    val usuarioDAO = dao.UsuarioDAO().pegarUm("teste")
    println(usuarioDAO)
    resultSet.close()
    connection.close()
}