package com.midaslibrary.managerLibrary.repository;


import com.midaslibrary.managerLibrary.model.entities.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<AuthorsEntity, String> {

    @Query(value = "SELECT A.author_id, " +
            "A.first_name, " +
            "A.last_name " +
            "FROM authors A " +
            "WHERE A.author_id = :author_id", nativeQuery = true)
    AuthorsEntity getAuthorById(@Param("author_id") Integer authorID);


    /*
    @Query(value = "SELECT B.book_id, " +
            "B.book_title, " +
            "B.summary, " +
            "B.volume, " +
            "B.release_date, " +
            "A.first_name, " +
            "A.last_name " +
            "FROM  books B " +
            "INNER JOIN authors A ON A.author_id = B.author_id " +
            "WHERE A.first_name = :first_name " +
            "AND A.author_id = :author_id", nativeQuery = true)
    BookAuthor getBooksByNameAuthor(@Param("first_name") String authorName,
                                    @Param("author_id") Integer authorID);
     */
}
