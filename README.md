## Welcome to Midas Biblioteca!

Hello, this is a project to manage a library called Midas Biblioteca, in it you can add users, books and authors, so that after the registration is possible to lend books to users, below we have the description of the project's features (which will be improved over time), technologies used and some usage tips.

>Status: Development... ⚠️

# Files explanation.

Here is some explanation of the files in each directory
 **SQL**: In this directory are the scripts for creating the tables used for the project.
 **ManagerLibrary**: In this directory is the API responsible for managing the library. Below you will find more details about it.
 **Json**:  In this directory are the request and response jsons for each application endpoint

# Technologies.

**Java**: The API responsible for managing the library is developed in Java 11.
**SpringBooT**: The API responsible for managing the library is used SpringBoot in version 2.5.6.
**DATABASE**: The relational database used is MySQL

## How to use the services

At the moment the manager allows you to register Users, Authors and their books, as well as update them. It is possible for a registered user to borrow available books (following the business rules).

### Tables used at the moment.

The script for creating the database, tables and example inserts are in the **sql** directory. Below are some explanations of the use of some tables.
**book_properties**: This table contains some properties of the registered books, which allow them to be borrowed.
**loans**: This table stores the loans per user and book, and is used for loan control.
### Routes ready at the moment.
>At the moment you can run the services locally, over time I will upgrade for uses in other environments.⚠️

**Following http://localhost:8080/midasBiblioteca...**

|                   Route                   |   Method  |                                                   Goal                                                |
|-------------------------------------------|-----------|-------------------------------------------------------------------------------------------------------|
|/user/{id}                                 |GET        |Returns simple data of a user, example file in the Json directory response_user_{id}                   |
|/user/{id}/data                            |GET        |Returns the complete data of a user, example file in the Json directory response_user_{id}_data        |
|/user                                      |POST       |To register simple user data, for example in body_user in the Json directory                           |
|/author/{id}                               |GET        |Returns simple data of a author, example file in the Json directory response_author_{id}               |
|/author                                    |POST       |To register simple author data, for example in body_author in the Json directory                       |
|/book/{id}                                 |GET        |Returns simple data of a book, example file in the Json directory response_book_{id}                   |
|/book                                      |POST       |To register simple book data, for example in body_book in the Json directory                           |
|/book/{id}/properties                      |GET        |Returns simple data of a book properties, example file in the Json directory response_book_{id}_prope  |
|/book/properties                           |POST       |To register simple book properties data, for example in body_bookProperties in the Json directory      |
|/loans-create                              |POST       |To register user loans, an example file is in the Json directory body_loans_create                     |
|/loan-renovation/{userId}/books/{bookId}   |PUT        |To renew a user's loan for a particular book                                                           |
|/loan-shutdown/{userId}/books/{bookId}     |PUT        |To finalize a loan, for a given user and book                                                          |
|-------------------------------------------|-----------|-------------------------------------------------------------------------------------------------------|