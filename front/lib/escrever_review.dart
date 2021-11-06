import 'package:flutter/material.dart';

class EscreverReview extends StatefulWidget {
  @override
  _State createState() => _State();
}

class _State extends State<EscreverReview> {
  TextEditingController nameController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    TextEditingController nomeReview = TextEditingController();
    TextEditingController Review = TextEditingController();

    return new Scaffold(
      body: new Column(
        children: <Widget>[
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              style: TextStyle(fontSize: 20),
              controller: nomeReview,
              decoration: new InputDecoration(
                hintText: "Nome",
              ),
            ),
          ),
          new ListTile(
            leading: const Icon(Icons.arrow_right),
            title: new TextField(
              controller: Review,
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
                print(nomeReview.text);
                print(Review.text);
              },
              child: Text("Publicar Review"),
            ),
        ],
      ),
    );
  }
}
