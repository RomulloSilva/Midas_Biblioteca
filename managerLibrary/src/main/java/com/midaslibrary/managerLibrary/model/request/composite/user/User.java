package com.midaslibrary.managerLibrary.model.request.composite.user;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Integer id;
    private String firstName;
    private String lastname;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime visitedAt;
    private String phone;
    private List<Loan> loans;
}
