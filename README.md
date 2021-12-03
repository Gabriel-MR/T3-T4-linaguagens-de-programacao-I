# Pop&Games

Projeto criado para ser um site onde um usuário pode fazer reviews sobre diversas categorias e títulos

## Integrantes

- Felipe Oliveira Boacnin - 19.00616-0
- Gabriel Domingues Garofalo - 19.01229-2
- Gabriel Moreira Silva – 19.00397-8
- Leonardo Bezerra Celestino Zollner - 19.02140-2

## Tecnologias Utilizadas

- GitHub (versionamento e backup)
- MariaDB (armazenar banco e poder acessar de qualquer lugar a qualquer momento)
- VirtualBox (utilizar MariaDB em uma VM)
- MySQL Workbench (banco de dados)
- Visual Studio Code (front-end/flutter)
- IntelliJ (back-end/kotlin)
- Ktor (servidor)


## Banco de Dados
![image](https://user-images.githubusercontent.com/73725151/142737226-ef2973e6-2722-48da-8397-98c84616b561.png)

Para o projeto, o grupo julgou necessário a criação de apenas 3 tabelas. Sendo elas:

###### Usuario
A tabela Usuario consiste em armazenar a informação dos usuários para fazer verificações de login, registros e posts. As informações necessárias são apenas o login, a senha e o email para manter esse controle.

###### Elementos
A tabela Elementos foi criada para armazenar os elementos que os usuários vão fazer reviews, para isso julgou-se necessário apenas a descrição do elemento, o nome do elemento e a categoria do elemento.

###### Review
A tabela Review foi criada para armazenar os reviews criados por esses usuários e e-mails importantes, pois se liga as duas tabelas. Para isso julgou-se necessários os campos review, sua data, o login de quem fez essa review e o id de qual elemento é esse review. Os últimos 2 vem respectivamente das tabelas Usuario e Elementos.

## Back-End

O backend foi desenvolvido em Kotlin. Inicialmente foram criado os models de cada uma das tabelas a partir das tabelas do MySQL usando os mesmos campos e mesmos tipos, após isso um DAO genérico, para que fosse possível padronizar tudo, um DAO de conexão e os DAO para cada tabela com suas respectivas query's.

```
interface GenericoDAO {
    fun pegarUm(login:String): Any
    fun inserirUm(objeto:Any): Unit
    fun pegarTodos(nome: String): List<Any>
    fun inserirVarios(lista:List<Any>): Unit
    fun atualizar(objeto: Any): Unit
    fun deletar(login: String): Unit
}
```

- A função pegarUm serve para pegar apenas um elemento de cada tabela
- A função inserirUm serve para adicionar um dos objetos em alguma tabela
- A função pegarTodos serve para pegar uma lista de objetos em alguma tabela
- A função inserirVarios serve para adicionar uma lista de objetos em alguma tabela
- A função atualizar serve para atualizar linhas das tabelas
- A função deletar serve para apagar linhas das tabelas

OBS: Para cada tabela, a implementação do método varia, portanto, para mais detalhes sobre o que foi feito e como foi implementado cada uma dessas funções em cada uma das tabelas, basta acessar o package dao e olhar qualquer um dos arquivos.

Uma vez que as conexões são no mesmo banco, não havia necessidade de ficar repetido a conexão com o banco. Para isso, criou-se o arquivo a seguir que padroniza para todos:
```
package dao

import java.sql.*

class ConnectionDAO {
    val connection : Connection
    var statement : Statement?
    var resultSet : ResultSet?
    var preparedStatement : PreparedStatement?

    init {
        this.connection = DriverManager.getConnection(shared.SharedPaths.STRING_CONEXAO_JDBC)
        this.statement = null
        this.resultSet = null
        this.preparedStatement = null
    }

    fun executeQuery(sqlString: String) : ResultSet?{
        this.statement = this.connection.createStatement()
        this.resultSet = this.statement?.executeQuery(sqlString)
        return this.resultSet
    }

    fun close(){
        this.resultSet?.close()
        this.statement?.close()
        this.preparedStatement?.close()
        this.connection.close()
    }

    fun getPreparedStatement(sqlString: String): PreparedStatement? {
        this.preparedStatement = this.connection?.prepareStatement(sqlString)
        return this.preparedStatement
    }

    fun commit() {
        this.connection?.commit()
    }
}
```

Exemplo de model (existe para todas as tabelas no package models):
```
data class Usuario(
    val login: String,
    val senha: String,
    val email: String
)

```

## Servidor

O servidor que o grupo decidiu utilizar foi o Ktor (https://ktor.io/) com a engine Netty.

```
embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
    install(CORS) {
        method(Options)
        anyHost()
    }

    routing {
        configureRouting()
    }
}.start(wait = true)
```

Dentro do configureRouting() que está loclizado no package plugins foram definidas as rotas utilizadas para o projeto sendo elas:

- "/login" -> fazer login
- "/register" -> registrar no site
- "/userpage" -> página do usuário onde o usuário pode-se ler e editar seus próprios reviews
- "/lerreview" - ler alguma review específica baseada nos filtros
- "/escreverreview" -> escrever alguma review

Para a transmissão de menssagem via API, usou-se o JSON.

## Front-End

O grupo decidiu criar o front-end em flutter por ser mais intuitivo e para aprender uma nova ferramenta, atráves de documentação, tutoriais e aulas. Julgou-se necessária a criação de 5 telas em Flutter, sendo elas:

###### Login

![image](https://user-images.githubusercontent.com/73725151/142737654-71eb25be-b92f-4ac0-b1ad-5010c053160d.png)

Aqui o usuário pode fazer login no site e caso não tenha conta, clicar no botão "Criar Conta" onde será redirecionado para a próxima página que é a de registro.

###### Criar uma Conta

![image](https://user-images.githubusercontent.com/73725151/142737992-c55b924a-bc05-44eb-a931-c00c1922f494.png)

Aqui o usuário pode se resgistrar no site caso não tenha uma conta. Se as senhas não baterem, o site não deixa criar a conta e assim que cria-se a conta, o visitante é redirecionado de volta a página de login para se fazer o login de forma correta.

###### Procurar um Review

![image](https://user-images.githubusercontent.com/73725151/142737882-94472387-21fa-4346-b036-d0feb040f970.png)

Aqui o usuário pode ler os reviews de qualquer elemento apenas digitando seu nome. Após isso, uma query é executada e retona todas as reviews do elemento buscado.

###### Escrever um Review

![image](https://user-images.githubusercontent.com/73725151/142737894-835c23ab-87e9-49a5-88ec-0cf7fd9334ae.png)

Aqui o usuário pode escrever os reviews de qualquer elemento apenas digitando seu nome e a review do elemento. Após isso, uma query é executada e adiciona o review na base.

###### Página do Usuário

![image](https://user-images.githubusercontent.com/73725151/142737949-1ab61d6c-8bd1-4a4c-a465-26b81d664eb4.png)

Aqui o usuário pode ver seus reviews de qualquer elemento apenas digitando seu nome e a review do elemento. Além disso, também pode apagar ou alterar alguma review apenas digitando o id que virá quando a tabela for exibida.

###### Este é o projeto. Esperamos que gostem. Obrigado!!!
