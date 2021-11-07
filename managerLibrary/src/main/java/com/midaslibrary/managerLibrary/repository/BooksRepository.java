package com.midaslibrary.managerLibrary.repository;


import com.midaslibrary.managerLibrary.model.entities.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, String> {

    @Query(value = "SELECT B.book_id, " +
            "B.book_title, " +
            "B.summary, " +
            "B.author_name, " +
            "B.author_id, " +
            "B.release_date, " +
            "B.volume, " +
            "B.isbn, " +
            "B.number_of_pages, " +
            "B.country, " +
            "B.publishing_company, " +
            "B.image_key " +
            "FROM books B " +
            "WHERE B.book_id = :book_id", nativeQuery = true)
    BooksEntity getBookById(@Param("book_id") Integer bookId);


    @Query(value = "SELECT B.book_title " +
            "FROM books B " +
            "WHERE B.book_id = :book_id", nativeQuery = true)
    String getBookTitle(@Param("book_id") Integer bookId);
}
