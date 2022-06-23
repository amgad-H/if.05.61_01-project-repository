import 'dart:ui';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:table_calendar/table_calendar.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key key}) : super(key: key);

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'SchoolPlanner',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or simply save your changes to "hot reload" in a Flutter IDE).
        // Notice that the counter didn't reset back to zero; the application
        // is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'SchoolPlanner'),
    );

  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;
  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String _dropdownValue;

  var child;


  CalendarFormat calendarFormat = CalendarFormat.week;
  CalendarFormat _switchCalender(String selectedValue){
    setState(() {
      _dropdownValue = selectedValue;
    });
    switch(selectedValue){
      case 'Week':
        calendarFormat = CalendarFormat.week;
        break;

      case 'Month':
        calendarFormat = CalendarFormat.month;
        break;
    }
    return calendarFormat;
  }


  DateTime selectedDay = DateTime.now();
  DateTime focusedDay = DateTime.now();

  String toDos = '';
  bool anyToDos = false;

  void _showToDos(int index){
    if(index == 1){
      showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('ToDos'),
            content: Text(toDos),
            backgroundColor: Colors.blueAccent,
            titleTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22, fontWeight: FontWeight.bold),
            contentTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22),
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
          )
      );
    }
    else if(index == 2){
      showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('Information'),
            content: Text('- Maskenpflicht fällt im ganzen Schulgebäude weg!'),
            backgroundColor: Colors.blueAccent,
            titleTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22, fontWeight: FontWeight.bold),
            contentTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22),
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
          )
      );
    }
  }

  void _showToDosOfDay(){
      showDialog(
          context: context,
          builder: (context) => AlertDialog(
            title: Text('ToDos'),
            content: Text(toDos),
            backgroundColor: Colors.blueAccent,
            titleTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22, fontWeight: FontWeight.bold),
            contentTextStyle: TextStyle(color: Colors.white, fontStyle: FontStyle.normal, fontSize: 22),
            shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
          )
      );
  }

  TextEditingController controller;

  @override
  void initState(){
    super.initState();

    controller = TextEditingController();
  }

  @override
  void dispose(){
    controller.dispose();

    super.dispose();
  }

  @override
  Widget build(BuildContext context)=>
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    Scaffold(
      backgroundColor: /*Colors.white10*/ Colors.white,
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.,
        title: Image(
          image: AssetImage('assets/SchoolPlanner_LOGO.jpeg'), height: 40,
        ),
        actions: [
          DropdownButton(iconEnabledColor: Colors.white, alignment: Alignment.center, dropdownColor: Colors.blueAccent, value: _dropdownValue, style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold, fontSize: 18), items: const [
            DropdownMenuItem(child: Text('Week'), value: 'Week'),
            DropdownMenuItem(child: Text('Month'), value: 'Month')
          ], onChanged: _switchCalender),
        ],


      ),
      body: TableCalendar(
        startingDayOfWeek: StartingDayOfWeek.monday,
        calendarStyle: CalendarStyle(
          todayDecoration: BoxDecoration(
            shape: BoxShape.rectangle,
            borderRadius: BorderRadius.circular(5.0),
            color: Colors.blueAccent
          ),
          selectedDecoration: BoxDecoration(
            color: Colors.green
        ),
        ),
        headerStyle: HeaderStyle(
          formatButtonVisible: false,
          titleCentered: true,
        ),
        onDaySelected: (DateTime selectedDay, DateTime focusedDay){
          _showToDosOfDay();
        },
          onDayLongPressed: (DateTime selectedDay, DateTime focusedDay) async {
            final toDo = await openDialog();
            if(toDo == null || toDo.isEmpty) return;

            setState(() => this.toDos = toDo);
          },
          focusedDay: DateTime.now(),
          firstDay: DateTime(1990),
          lastDay: DateTime(2050),
          calendarFormat: calendarFormat,
      ),
      bottomNavigationBar: BottomNavigationBar(
        selectedItemColor: Colors.white,
        onTap: (int Index){
          _showToDos(Index);
        },
        backgroundColor: Colors.blueAccent,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
            backgroundColor: Colors.white,

          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.feed),
            label: 'ToDos',
            backgroundColor: Colors.white,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.info),
            label: 'Info',
            backgroundColor: Colors.white,
          ),
        ],
      ),// This trailing comma makes auto-formatting nicer for build methods.
    );

  Future<String> openDialog() => showDialog<String>(
      context: context,
      builder: (context) => AlertDialog(
        title: Text('Enter your ToDos for this day'),
        content: TextField(
          decoration: InputDecoration(hintText: 'ToDos...'),
          controller: controller,
        ),
        actions: [
          TextButton(
            onPressed: (){
              addTodos();
            },
            child: Text('ADD'),
          )
        ],
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(15)),
      ),
  );

  void addTodos() {
    Navigator.of(context).pop(controller.text);
    anyToDos = true;
    controller.clear();
  }
}
