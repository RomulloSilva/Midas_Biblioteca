package com.envioemail.producerfila.repository;

import com.envioemail.producerfila.model.entitys.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, String> {


    @Query(value = "SELECT COUNT(L.expired) " +
            "FROM loans L " +
            "WHERE L.users_id = :users_id " +
            "AND L.expired = '1'", nativeQuery = true)
    Integer userWithExpiration(@Param("users_id") Integer userId);


    @Query(value = "SELECT COUNT(L.book_id) " +
            "FROM loans L " +
            "WHERE L.users_id = :users_id " +
            "AND L.book_id = :book_id " +
            "AND L.active_loan = '1'", nativeQuery = true)
    Integer userAlreadyLentThisBook(@Param("users_id") Integer userId,
                                    @Param("book_id") Integer bookId);
}
