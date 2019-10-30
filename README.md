# Mr X Inventory
The application XInventory is built on MVC design pattern as this design pattern makes the code modular and easy to understand. The application takes input commands endlessly until the user inputs the command '#'(without quotes) in the console. The application will then render all the Inventory information of Mr.X like Item Name, Cost Price, Selling Price, Available quantity, Value and Total Profit since last report generation at the instances where ever the command input 'report' is given.

Although validation for input string is given, few of the corner cases were not handled assuming the user enter those inputs properly. For example the application would identify reportX as a faulty input command but not report X. Such cases are not recognised.

When it comes to the functionality, the application gives a scalable, quick solution as any operation takes not more than O(n) time complexity. And as said the solution is modular, therefore the code is easy to maintain and enhance.

Unit tests that cover almost every line of code(service layer) have been included.

Programming language : Java
IDE 		     : Eclipse
Testing              : Developer Testing unit test (Junits)
UML Class Diagram    : UML Lab
