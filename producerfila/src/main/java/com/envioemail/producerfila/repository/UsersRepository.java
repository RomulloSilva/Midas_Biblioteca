package com.envioemail.producerfila.repository;

import com.envioemail.producerfila.model.entitys.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

    @Query(value = "SELECT U.users_id, " +
            "U.first_name, " +
            "U.last_name, " +
            "U.email, " +
            "U.birth_date, " +
            "U.visited_at, " +
            "U.phone " +
            "FROM users U " +
            "WHERE U.users_id = :users_id", nativeQuery = true)
    UsersEntity getUserByID(@Param("users_id") Integer authorID);
}
