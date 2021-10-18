package com.envioemail.producerfila.model.entitys;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_properties")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookPropertiesEntity implements Serializable {

    private static final long serialVersionUID = 995272728138800621L;

    @Id
    @Column(name = "book_id", unique = true, nullable = false)
    private Integer bookId;

    @Column(name = "available_quantity", nullable = false)
    private Integer availableQuantity;

    @Column(name = "rated_r", nullable = false)
    private String ratedr;

    @Column(name = "borrowed_quantity", nullable = false)
    private Integer borrowedQuantity;

    @Column(name = "reserved_quantity", nullable = false)
    private Integer reservedQuantity;

    @Column(name = "quantity_available_for_loan", nullable = false)
    private Integer quantityAvailableForLoan;

    @Column(name = "available_on_date", nullable = false)
    private Integer availableOnDate;

}
