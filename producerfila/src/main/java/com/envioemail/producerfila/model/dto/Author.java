package com.envioemail.producerfila.model.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {


    private static final long serialVersionUID = -7338510457572615954L;
    private String authorFirstName;
    private String authorLastName;
}
