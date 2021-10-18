package dao

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class ConnectionDAO {
    val connection : Connection
    var statement : Statement?
    var resultSet : ResultSet?

    init {
        this.connection = DriverManager.getConnection(shared.SharedPaths.STRING_CONEXAO_JDBC)
        this.statement = null
        this.resultSet = null
    }

    fun executeQuery(sqlString: String) : ResultSet?{
        this.statement = this.connection.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet
    }

    fun close(){
        this.resultSet?.close()
        this.statement?.close()
        this.connection.close()
    }
}