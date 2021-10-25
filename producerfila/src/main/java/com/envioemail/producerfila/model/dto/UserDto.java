package com.envioemail.producerfila.model.dto;

import com.envioemail.producerfila.config.validators.SafeTextValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Pattern.Flag;
import java.io.Serializable;
import java.time.LocalDate;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {


    private static final long serialVersionUID = -3899156131829529619L;

    @NotBlank(message = "User's first name cannot be blank")
    @NotNull(message = "User's first name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String firstName;

    @NotBlank(message = "User's last name cannot be blank")
    @NotNull(message = "User's last name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String lastname;

    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", flags = Flag.CASE_INSENSITIVE, message = "Invalid email.")
    private String email;

    @Past(message = "Invalid birth date.")
    @NotNull(message = "Birth date cannot be null")
    private LocalDate birthDate;

    @NotBlank(message = "Phone cannot be blank")
    @NotNull(message = "Phone cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", flags = Flag.UNICODE_CASE, message = "Invalid phone number.")
    private String phone;
}
