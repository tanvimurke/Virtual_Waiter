# Virtual_Waiter
We propose to build a software project that can efficiently handle and manage various activities of a restaurant and all these activities will be happening under the supervision of the administrator. The businesses in restaurants are now growing constantly. At the same time, the need for managing its operations and tasks arises. The best way to optimize these activities is growing the business online as well. Today's generation encourages high-tech services especially over the Internet. Hence the project is developed proficiently to help restaurant owners automate their business operations. This project serves the best way of maintaining customer's information and caters their needs.
System presents an interactive and up-to-date menu with all available options in an easy to use manner. Customer can choose one or more items to place an order. Once the order is placed it is entered in the database and retrieved in pretty much real time. This allows Restaurant Employees to quickly go through the orders as they are received and process all orders efficiently and effectively with minimal delays and confusion.
Six Sands Self-Order Menu is an app that allows customers to order food from the Six Sands restaurant all on their own. With an eMenu and self-ordering system, customers can use a self-service kiosk in the restaurant driveway or a self-ordering terminal at a table to access the restaurant menu and order a meal. This ensures prompt order processing at peak times, improves the overall service speed, and reduces wait times to ultimately increase customer satisfaction.

Available in 2 modes:
Kiosk mode - Ideal for quick service restaurant environments. The customer orders directly on the app, then waits for the order. The admin can view the orders and also delete them once being served.
Table mode - Ideal for multi-order, table service restaurant environments. The app is affiliated with a specific table. With the help of waitstaff, the customer can place several orders.
The application has been developed using Android Studio as IDE and Firebase for database management.

## Working
Some important functions and classes that are included in the project:
1. Text To Speech:
Android allows you convert your text into voice. Not only you can convert it but it also allows you to speak text in variety of different languages.
Android provides TextToSpeech class for this purpose. In order to use this class, you need to instantiate an object of this class and also specify the initListener. 
In this listener, you have to specify the properties for TextToSpeech object , such as its language ,pitch e.t.c. Language can be set by calling setLanguage() method. The method setLanguage takes an Locale object as parameter. Once you have set the language, you can call speak method of the class to speak the text. Apart from the speak method, there are some other methods available in the TextToSpeech class.
2.Intent
An Android Intent is an abstract description of an operation to be performed. It can be used with startActivity to launch an Activity. The intent itself, an Intent object, is a passive data structure holding an abstract description of an operation to be performed.
An Intent object is a bundle of information which is used by the component that receives the intent as well as information used by the Android system.
3.Firebase
Firebase is a backend platform for building Web, Android and IOS applications. It offers real time database, different APIs, multiple authentication types and hosting platform. This is an introductory tutorial, which covers the basics of the Firebase platform and explains how to deal with its various components and sub-components.
Real-time Database - Firebase supports JSON data and all users connected to it receive live updates after every change.
4.ListView
Android ListView is a view which groups several items and display them in vertical scrollable list. The list items are automatically inserted to the list using an Adapter that pulls content from a source such as an array or database. An adapter actually bridges between UI components and the data source that fill data into UI Component. Adapter holds the data and send the data to adapter view, the view can takes the data from adapter view and shows the data on different views like as spinner, list view, grid view etc.

Working:
1. When you open the app you can select either user or admin.
2. If you are user then you can directly view the menu.
3. Browse for the menu where images, description, voice assistance would help you to choose your order.
4.By switching on the button your order will be placed.
5.If you are an admin then log in into the app using password.
6.You would be able to view the orders that the customers have placed.
7.After serving the order you can clear the page as well
