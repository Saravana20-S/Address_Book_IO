# Advanced Address Book IO

A Java-based Address Book application developed using Object-Oriented Programming principles. The application allows users to manage multiple contacts, perform search and sorting operations, prevent duplicate entries, and persist contact information using CSV, JSON, and REST APIs. The project also demonstrates Java 8 features such as Streams, Lambda Expressions, and asynchronous programming with `CompletableFuture`.

---

## Features

### Contact Management
- Add a new contact
- Edit existing contact details
- Delete a contact
- Display all contacts
- Manage multiple contacts using Java Collections
- Prevent duplicate contacts based on person's name

### Search & Sorting
- Sort contacts by Name
- Sort contacts by City
- Sort contacts by State
- Sort contacts by ZIP Code
- View contacts by City
- View contacts by State
- Search contacts by City
- Search contacts by State

### File Operations
- Read and write contacts as CSV files using OpenCSV
- Read and write contacts as JSON files using Gson
- Read and write contacts to a JSON Server using REST Assured

### Java 8 Features
- Stream API
- Lambda Expressions
- Method References
- Comparator
- CompletableFuture for asynchronous I/O operations

---

## Technologies Used

- Java 8+
- Maven
- IntelliJ IDEA
- OpenCSV
- Gson
- REST Assured
- JSON Server
- Java Collections Framework
- Java Stream API

---

## Project Structure

```
Advanced-AddressBook-IO
│── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── bridgelabz
│   │   │           └── advaddressbookio
│   │   │               ├── main
│   │   │               ├── model
│   │   │               ├── service
│   │   │               └── util
│   │   └── resources
│   │       ├── addressbook.csv
│   │       └── addressbook.json
│   └── test
├── pom.xml
└── README.md
```

---

## Maven Dependencies

### OpenCSV

```xml
<dependency>
    <groupId>com.opencsv</groupId>
    <artifactId>opencsv</artifactId>
    <version>5.12.0</version>
</dependency>
```

### Gson

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.13.1</version>
</dependency>
```

### REST Assured

```xml
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>5.5.6</version>
</dependency>
```

---

## How to Run

1. Clone the repository

```bash
git clone <repository-url>
```

2. Open the project in IntelliJ IDEA

3. Reload Maven dependencies

4. Run the `Main` class

---

## JSON Server Setup

Install JSON Server

```bash
npm install -g json-server
```

Create a `db.json` file

```json
{
  "contacts": []
}
```

Start the server

```bash
json-server --watch db.json --port 3000
```

The server will be available at

```
http://localhost:3000
```

---

## Learning Outcomes

- Object-Oriented Programming
- Collections Framework
- Java Stream API
- Lambda Expressions
- Method References
- Comparator
- Exception Handling
- File Handling
- CSV Processing using OpenCSV
- JSON Processing using Gson
- REST API Testing using REST Assured
- Asynchronous Programming using CompletableFuture
- Maven Project Management
- Git Branching and Version Control

---

## Git Workflow

- `main` – Stable production branch
- `dev` – Development branch
- `feature/*` – Individual feature branches for each use case

Example:

```
main
│
└── dev
    ├── feature/UC1-create-contact
    ├── feature/UC2-add-person
    ├── feature/UC3-edit-contact
    ├── ...
    └── feature/UC15-asynchronous-io
```

---

## Author

**Saravanan S**

Java Developer | Core Java | Java Collections | Java Streams | File I/O | REST APIs | Maven
