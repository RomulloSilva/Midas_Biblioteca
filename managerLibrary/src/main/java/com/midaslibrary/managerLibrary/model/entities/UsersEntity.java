package com.midaslibrary.managerLibrary.model.entities;


import com.midaslibrary.managerLibrary.model.dto.UserDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = -2613037985011098803L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String lastname;

    @Column(name = "email", length = 80, nullable = false, unique = true)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "visited_at")
    private LocalDateTime visitedAt;

    @Column(name = "phone")
    private String phone;

    public static UsersEntity of(UserDto userDto) {
        return UsersEntity.builder()
                .firstName(userDto.getFirstName())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .birthDate(userDto.getBirthDate())
                .visitedAt(LocalDateTime.now())
                .phone(userDto.getPhone())
                .build();
    }
}
