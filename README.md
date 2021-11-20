# Pop&Games

Projeto criado para ser um site onde um usuário pode fazer reviews sobre diversas categorias e título com um frontend em Flutter, um backend em Kotlin e a base de dados em MySQL

## Banco de Dados
![image](https://user-images.githubusercontent.com/73725151/142737226-ef2973e6-2722-48da-8397-98c84616b561.png)

Para o projeto o grupo julgou necessário a criação de apenas 3 tabelas. Sendo elas:

###### Usuario
A tabela Usuario consiste em aramzenar a informação dos usuários para fazer verificações de login, registros e posts. As informações necessárias são apenas o login, a senha e o email para manter esse controle

###### Elementos
A tabela Elementos foi criada para armazenar os elementos que os usuários vão fazer reviews, para isso julgou-se necessário apenas neccesário a descrição do elemento, o nome do elemento e a categoria do elemento.

###### Review
A tabela Review foi criada para armazenar os reviews criados por esses usuários e é mais importante pois se liga as duas tabelas, para isso julgou-se necessários os campos review, sua data, o login de quem fez essa review e o id de qual elemento é esse review. Os últimos 2 vem respectivamente das tabelas Usuario e Elementos.

## Back-End


## Front-End

O grupo julgou necessária a criação de 5 telas em Flutter, sendo elas:

###### Login

![image](https://user-images.githubusercontent.com/73725151/142737654-71eb25be-b92f-4ac0-b1ad-5010c053160d.png)


###### Criar uma Conta

![image](https://user-images.githubusercontent.com/73725151/142737992-c55b924a-bc05-44eb-a931-c00c1922f494.png)


###### Procurar um Review

![image](https://user-images.githubusercontent.com/73725151/142737882-94472387-21fa-4346-b036-d0feb040f970.png)


###### Escrever um Review

![image](https://user-images.githubusercontent.com/73725151/142737894-835c23ab-87e9-49a5-88ec-0cf7fd9334ae.png)


###### Página do Usuário

![image](https://user-images.githubusercontent.com/73725151/142737949-1ab61d6c-8bd1-4a4c-a465-26b81d664eb4.png)
