import 'package:flutter/material.dart';

class UserPage extends StatefulWidget {
  @override
  _State createState() => _State();
}

class _State extends State<UserPage> {
  TextEditingController id = TextEditingController();
  TextEditingController novoReview = TextEditingController();
  TextEditingController acao = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Column(
        children: <Widget>[
          DataTable(
            columns: const <DataColumn>[
              DataColumn(
                label: Text(
                  'id',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'Review',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'Data',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'User',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'Elemento',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
            ],
            rows: const <DataRow>[
              DataRow(
                cells: <DataCell>[
                  DataCell(Text('id')),
                  DataCell(Text('Review')),
                  DataCell(Text('Data')),
                  DataCell(Text('User')),
                  DataCell(Text('Elemento'))
                ],
              ),
            ],
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              style: TextStyle(fontSize: 20),
              controller: acao,
              decoration: new InputDecoration(
                hintText: "Ação (Editar/Apagar)",
              ),
            ),
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              controller: id,
              style: TextStyle(fontSize: 20),
              decoration: new InputDecoration(
                hintText: "Novo Review",
              ),
            ),
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              controller: novoReview,
              style: TextStyle(fontSize: 20),
              decoration: new InputDecoration(
                hintText: "id",
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
              print(id.text);
              print(novoReview.text);
              print(acao.text);
            },
            child: Text("Avançar"),
          ),
        ],
      ),
    );
  }
}
