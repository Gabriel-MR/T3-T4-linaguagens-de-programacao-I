package dao

interface GenericoDAO {
    fun pegarUm(login:String): Any
    fun inserirUm(objeto:Any): Unit
    fun pegarTodos(nome: String): List<Any>
    fun inserirVarios(lista:List<Any>): Unit
    fun atualizar(objeto: Any): Unit
    fun deletar(login: String): Unit
}