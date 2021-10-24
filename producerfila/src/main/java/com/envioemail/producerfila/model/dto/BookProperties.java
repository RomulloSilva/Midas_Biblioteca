package com.envioemail.producerfila.model.dto;


import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookProperties implements Serializable {

    private static final long serialVersionUID = -2530521520183639821L;

    private Integer bookId;
    private Integer availableQuantity;
    private String ratedr;
    private Integer borrowedQuantity;
    private Integer reservedQuantity;
    private Integer quantityAvailableForLoan;
    private Integer availableOnDate;
}
