Run the application using springboot's embedded tomcat.
Database: PostgreSQL

Database pointers can be changed in application.properties

The API should allow API user to perform the following actions:
1. Register a new borrower to the library.
  POST http://localhost:8080/borrowers
  {
  "name": "Ali",
  "email": "ali@ali.com"
}
2. Register a new book to the library.
  POST http://localhost:8080/books
  {
  "isbnNumber": 1,
  "title": "alititle",
  "author": "aliauthor"
}
3. Get a list of all books in the library.
  GET http://localhost:8080/books

The API should allow API user to perform the following actions on behalf of a borrower:
1. Borrow a book with a particular book id (refer Book in Data Models).
  GET http://localhost:8080/borrowers/{borrowerId}/books/{bookId}/borrow
2. Return a borrowed book
  GET http://localhost:8080/borrowers/{borrowerId}/books/{bookId}/return
