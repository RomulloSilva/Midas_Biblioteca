package com.envioemail.producerfila.repository;

import com.envioemail.producerfila.model.entitys.BookPropertiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
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
            "P.available_on_date, " +
            "FROM book_properties P " +
            "WHERE P.book_id = :book_id", nativeQuery = true)
    BookPropertiesEntity getBookPropertiesById(@Param("book_id") Integer bookId);
}
