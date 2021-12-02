import 'dart:convert';

ModeloUsuario modeloUsuarioFromJson(String str) => ModeloUsuario.fromJson(json.decode(str));

String modeloUsuarioToJson(ModeloUsuario data) => json.encode(data.toJson());

class ModeloUsuario {
  
    String login;
    String senha;
    
    ModeloUsuario({
      required this.login,
      required this.senha,
    });

    factory ModeloUsuario.fromJson(Map<String, dynamic> json) => ModeloUsuario(
        login: json["login"],
        senha: json["senha"],
    );

    Map<String, dynamic> toJson() => {
        "login": login,
        "senha": senha,
    };
}