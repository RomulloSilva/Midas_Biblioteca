package com.midaslibrary.managerLibrary.repository;


import com.midaslibrary.managerLibrary.model.entities.BookPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPropertiesRepository extends JpaRepository<BookPropertiesEntity, String> {

    @Query(value = "SELECT  P.book_id, " +
            "P.available_quantity, " +
            "P.rated_r, " +
            "P.borrowed_quantity, " +
            "P.reserved_quantity, " +
            "P.quantity_available_for_loan, " +
            "P.available_on_date " +
            "FROM book_properties P " +
            "WHERE P.book_id = :book_id", nativeQuery = true)
    BookPropertiesEntity getBookPropertiesById(@Param("book_id") Integer bookId);


    @Query(value = "SELECT BP.quantity_available_for_loan " +
            "FROM book_properties BP " +
            "WHERE BP.book_id = :book_id", nativeQuery = true)
    Integer bookAvailable(@Param("book_id") Integer bookId);

    @Modifying
    @Query(value = "UPDATE book_properties " +
            "SET quantity_available_for_loan = quantity_available_for_loan - 1, " +
            "borrowed_quantity = borrowed_quantity + 1 " +
            "WHERE book_id = :book_id", nativeQuery = true)
    void updateQuantityAvailable(@Param("book_id") Integer bookId);
}
