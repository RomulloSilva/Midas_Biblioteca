package com.envioemail.producerfila.repository;

import com.envioemail.producerfila.model.entitys.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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


    @Query(value = "SELECT L.loans_id," +
            "L.book_id," +
            "L.users_id," +
            "L.date_of_loan, " +
            "L.expiration_date, " +
            "L.expired, " +
            "L.active_loan " +
            "FROM loans L " +
            "WHERE L.users_id = :users_id", nativeQuery = true)
    List<LoanEntity> findAllLoan(@Param("users_id") Integer userId);

    @Query(value = "SELECT L.loans_id," +
            "L.book_id," +
            "L.users_id," +
            "L.date_of_loan, " +
            "L.expiration_date, " +
            "L.expired, " +
            "L.active_loan " +
            "FROM loans L " +
            "WHERE L.users_id = :users_id " +
            "AND L.book_id = :book_id " +
            "AND L.active_loan = '1'", nativeQuery = true)
    Optional<LoanEntity> findLoanActive(@Param("users_id") Integer userId,
                                        @Param("book_id") Integer bookId);


    @Query(value = "SELECT L.loans_id " +
            "FROM loans L " +
            "WHERE L.users_id = :users_id " +
            "AND L.book_id = :book_id " +
            "AND L.active_loan = '1'", nativeQuery = true)
    Integer findLoanId(@Param("users_id") Integer userId,
                       @Param("book_id") Integer bookId);


    @Modifying
    @Query(value = "UPDATE loans " +
            "SET active_loan = '0' " +
            "WHERE loans_id = :loans_id", nativeQuery = true)
    Integer closeLoan(@Param("loans_id") Integer loanId);
}
