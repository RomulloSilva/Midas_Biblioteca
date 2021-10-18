create database midasbilioteca;

use midasbilioteca;

--TABELA DE USUARIOS
CREATE TABLE users (
    users_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (50) NOT NULL,
    last_name VARCHAR (50) NOT NULL,
    email VARCHAR(80) NOT NULL,
    birth_date DATE NOT NULL UNIQUE,
    visited_at DATETIME,
    phone VARCHAR(20)
);
--TABELA DE AUTORES
CREATE TABLE authors (
    author_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR (50) NOT NULL,
    last_name VARCHAR (50) NOT NULL,
);

--TABELA DE LIVROS
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR (50) NOT NULL,
    summary VARCHAR(300) NOT NULL,
    author_name VARCHAR (50) NOT NULL,
    author_id INT NOT NULL,
    release_date DATE NOT NULL,
    volume INT NOT NULL,
    isbn INT NOT NULL,
    number_of_pages INT NOT NULL,
    country VARCHAR(30) NOT NULL,
    publishing_company  VARCHAR(50) NOT NULL,
	FOREIGN KEY (author_id) REFERENCES authors (author_id)
);

--INSERT NA TABELA USERS
INSERT INTO users(first_name,last_name ,email,birth_date,visited_at,phone) VALUES ('Romulo', 'Last Name', 'emailExample@gmail.com', '1995-12-19', '18-10-21 10:34:09', '11989652536');


--INSERT TABELA AUTORES
insert into authors(author_id,first_name,last_name) values (null, "George", " R. R. Martin");
insert into authors(author_id,first_name,last_name) values (null, "Agatha", "Christie");
insert into authors(author_id,first_name,last_name) values (null, "Clarice", "Lispector");

--INSERT NA TABELA DE LIVROS
insert into books(book_id,book_title,summary,author_name,author_id,release_date,volume,isbn,number_of_pages,country,publishing_company) values (null, "A Guerra Dos Tronos - As Crônicas De Gelo e Fogo","resumo", "George R. R. Martin", 1, "02-06-19", 1, 9788556510785, 900, "Brasil", "Suma De Letras");

--TABELA DE LIVROS
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    book_title VARCHAR (50) NOT NULL,
    summary VARCHAR(300) NOT NULL,
    author_name VARCHAR (50) NOT NULL,
    author_id INT NOT NULL,
    release_date DATE NOT NULL,
    volume INT NOT NULL,
    isbn INT NOT NULL,
    number_of_pages INT NOT NULL,
    country VARCHAR(30) NOT NULL,
    publishing_company  VARCHAR(50) NOT NULL,
	FOREIGN KEY (author_id) REFERENCES authors (author_id)
);