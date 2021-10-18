package com.envioemail.producerfila.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {


    private static final long serialVersionUID = -3899156131829529619L;
    private String firstName;
    private String lastname;
    private String email;
    private LocalDate birthDate;
    private LocalDateTime visitedAt;
    private String phone;
}
