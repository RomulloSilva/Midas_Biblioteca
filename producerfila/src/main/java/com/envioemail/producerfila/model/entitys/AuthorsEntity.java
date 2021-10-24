package com.envioemail.producerfila.model.entitys;

import com.envioemail.producerfila.model.dto.Author;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authors")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorsEntity implements Serializable {


    private static final long serialVersionUID = -8730287336061501018L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "first_name", length = 50, nullable = false)
    private String authorFirstName;

    @Column(name = "last_name", length = 50, nullable = false)
    private String authorLastName;

    public static AuthorsEntity of(Author author) {
        return AuthorsEntity.builder()
                .authorFirstName(author.getAuthorFirstName())
                .authorLastName(author.getAuthorLastName())
                .build();
    }

}
