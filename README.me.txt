Library Management System

Description : 
This is a simple Library Management System built in Java to manage books and users. It allows you to add books, add users, issue books to users, return books, and display the current state of the library.

Features
Book Management: Add and display books in the library.

User Management: Add and display users in the library.

Issue Books: Users can issue books if available.

Return Books: Users can return issued books to make them available again.

Availability Check: Books are marked as available or unavailable based on the issue and return status.

Classes
Book: Represents a book in the library with attributes like id, title, and isAvailable.

User: Represents a user with attributes like userId, name, and a list of issuedBooks.

Library: Manages the collection of books and users, providing methods to issue, return, and display books and users.

How to Run
Prerequisites
Java 8 or later installed on your machine.

A basic text editor or Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse.

Steps to Run:
Clone or download the code into a folder on your computer.

Open the folder in your Java IDE or any text editor.

Compile and run the LibraryManagementSystem class.

The system will display books and users, then allow you to issue and return books.

Example of Output:
plaintext
Copy
Edit
Books in Library:
Book{id=1, title='Java Programming', isAvailable=true}
Book{id=2, title='Data Structures', isAvailable=true}
Book{id=3, title='Design Patterns', isAvailable=true}

Users in Library:
User{id=101, name='Alice', issuedBooks=[]}
User{id=102, name='Bob', issuedBooks=[]}

Book issued: Java Programming
Book issued: Data Structures

Books in Library:
Book{id=1, title='Java Programming', isAvailable=false}
Book{id=2, title='Data Structures', isAvailable=false}
Book{id=3, title='Design Patterns', isAvailable=true}

Users in Library:
User{id=101, name='Alice', issuedBooks=[Book{id=1, title='Java Programming', isAvailable=false}]}
User{id=102, name='Bob', issuedBooks=[Book{id=2, title='Data Structures', isAvailable=false}]}

Book returned: Java Programming
Book returned: Data Structures

Books in Library:
Book{id=1, title='Java Programming', isAvailable=true}
Book{id=2, title='Data Structures', isAvailable=true}
Book{id=3, title='Design Patterns', isAvailable=true}

Users in Library:
User{id=101, name='Alice', issuedBooks=[]}
User{id=102, name='Bob', issuedBooks=[]}

License :
This project is open source. Feel free to modify and use it as needed.

