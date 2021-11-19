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
                  'Name',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'Age',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
              DataColumn(
                label: Text(
                  'Role',
                  style: TextStyle(fontStyle: FontStyle.italic),
                ),
              ),
            ],
            rows: const <DataRow>[
              DataRow(
                cells: <DataCell>[
                  DataCell(Text('Sarah')),
                  DataCell(Text('19')),
                  DataCell(Text('Student')),
                ],
              ),
              DataRow(
                cells: <DataCell>[
                  DataCell(Text('Janine')),
                  DataCell(Text('43')),
                  DataCell(Text('Professor')),
                ],
              ),
              DataRow(
                cells: <DataCell>[
                  DataCell(Text('William')),
                  DataCell(Text('27')),
                  DataCell(Text('Associate Professor')),
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
                hintText: "Nome",
              ),
            ),
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              controller: id,
              style: TextStyle(fontSize: 20),
              decoration: new InputDecoration(
                hintText: "Review",
              ),
            ),
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              controller: novoReview,
              style: TextStyle(fontSize: 20),
              decoration: new InputDecoration(
                hintText: "Review",
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
