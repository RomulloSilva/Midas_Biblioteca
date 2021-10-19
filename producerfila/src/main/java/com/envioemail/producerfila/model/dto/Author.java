package com.envioemail.producerfila.model.dto;

import com.envioemail.producerfila.config.validators.SafeTextValidator;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {


    private static final long serialVersionUID = -7338510457572615954L;

    @NotBlank(message = "Author's first name cannot be blank")
    @NotNull(message = "Author's first name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String authorFirstName;

    @NotBlank(message = "Author's first name cannot be blank")
    @NotNull(message = "Author's last name cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String authorLastName;
}
