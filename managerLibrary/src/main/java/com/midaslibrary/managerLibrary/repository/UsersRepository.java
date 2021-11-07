package com.midaslibrary.managerLibrary.repository;


import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {

    @Query(value = "SELECT U.users_id, " +
            "U.first_name, " +
            "U.last_name, " +
            "U.email, " +
            "U.birth_date, " +
            "U.visited_at, " +
            "U.phone, " +
            "U.image_key " +
            "FROM users U " +
            "WHERE U.users_id = :users_id", nativeQuery = true)
    UsersEntity getUserByID(@Param("users_id") Integer userId);


    @Query(value = "SELECT U.first_name " +
            "FROM users U " +
            "WHERE U.users_id = :users_id", nativeQuery = true)
    Optional<String> getUserName(@Param("users_id") Integer userId);


    @Modifying
    @Query(value = "UPDATE users U " +
            "SET U.image_key = :image_key " +
            "WHERE U.users_id = :users_id", nativeQuery = true)
    void setImageKey(@Param("users_id") Integer userId,
                     @Param("image_key") String imageKey);
}
