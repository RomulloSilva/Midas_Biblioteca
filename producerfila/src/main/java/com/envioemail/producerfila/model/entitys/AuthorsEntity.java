package com.envioemail.producerfila.model.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authors")
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

}
