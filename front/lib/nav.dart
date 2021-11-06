import 'package:flutter/material.dart';
import 'package:pop_games/login.dart';
import 'package:pop_games/register.dart';
import 'escrever_review.dart';


class NavBar extends StatefulWidget {
  @override
  _State createState() => _State();
}

class _State extends State<NavBar> {
  @override
  Widget build(BuildContext context) {
       return MaterialApp(
      home: DefaultTabController(
        length: 3,
        child: Scaffold(
          appBar: AppBar(
            bottom: TabBar(
              tabs: [
                Tab(text: 'Ler Reviews'),
                Tab(text: 'Escrever um Review',),
                Tab(text: 'Meus Reviews'),
              ],
            ),
            title: Text('Pop&Games'),
          ),
          body: TabBarView(
            children: [
             LoginPage(),
             EscreverReview(),
             RegisterPage()
            ],
          ),
        ),
      ),
    );
  }
}