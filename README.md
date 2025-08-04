# Java Console-Based Library Management System

This is a simple **Java console application** designed to manage a small library system. Users can add, search, borrow, and return books through a user-friendly terminal interface.

---

## Features

- Add new books to the library
- Search books by:
  - Title
  - Author
  - ISBN
  - Borrowing status
- Borrow or return a book
- View all books
- Loopable UI with action options (Repeat, Return to Menu, Quit)

---

## Architecture

This project follows a clean, layered architecture:

com.patika.library
├── controller # Controls logic between UI and service layer
├── model # Book entity class
├── repository # In-memory book storage
├── service # Business logic (book validation, borrowing)
├── ui # Console-based user interface
└── util # Utility classes (printer, user actions, flow handler)

---

## Tech Stack

- Java 17+
- JDK standard libraries only (no external dependencies)
- Console I/O via `Scanner`

---

##  How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/java-library-console-app.git

   cd java-library-console-app

   javac com/patika/library/Main.java

   java com.patika.library.Main

## Author

Canberk Sarıkaya
