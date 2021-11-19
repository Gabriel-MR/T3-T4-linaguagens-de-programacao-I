import 'package:flutter/material.dart';

class LerReview extends StatefulWidget {
  @override
  _State createState() => _State();
}

class _State extends State<LerReview> {
  TextEditingController nomeElemento = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Column(
        children: <Widget>[
          new ListTile(
            leading: const Icon(Icons.search),
            title: new TextField(
              style: TextStyle(fontSize: 20),
              controller: nomeElemento,
              decoration: new InputDecoration(
                hintText: "Nome Elemento",
              ),
            ),
          ),
          const Divider(
            height: 1.0,
          ),
          FlatButton(
            textColor: Colors.white,
            color: Colors.blue,
            onPressed: () {
              print(nomeElemento.text);
            },
            child: Text("Procurar Review"),
          ),
        ],
      ),
    );
  }
}
