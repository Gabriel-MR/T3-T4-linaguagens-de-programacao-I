import models.Usuario
import java.sql.DriverManager

fun main(args: Array<String>) {
    // Conexão com o banco
    val connection = DriverManager.getConnection("jdbc:mariadb://192.168.56.101:3306/Pop_Games?user=admin&password=admin")
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
    resultSet.close()
    connection.close()
}