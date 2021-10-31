package com.midaslibrary.managerLibrary.model.entities;


import com.midaslibrary.managerLibrary.model.dto.BookProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    private LocalDateTime availableOnDate;

    public static BookPropertiesEntity of(BookProperties bookProperties) {
        return BookPropertiesEntity.builder()
                .bookId(bookProperties.getBookId())
                .availableQuantity(bookProperties.getAvailableQuantity())
                .ratedr(bookProperties.getRatedr())
                .borrowedQuantity(bookProperties.getBorrowedQuantity())
                .reservedQuantity(bookProperties.getReservedQuantity())
                .quantityAvailableForLoan(bookProperties.getQuantityAvailableForLoan())
                .availableOnDate(bookProperties.getAvailableOnDate()).build();
    }

}
