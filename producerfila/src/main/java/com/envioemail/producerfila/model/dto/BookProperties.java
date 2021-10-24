package com.envioemail.producerfila.model.dto;


import com.envioemail.producerfila.config.validators.SafeTextValidator;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookProperties implements Serializable {

    private static final long serialVersionUID = -2530521520183639821L;


    @NotNull(message = "BookId cannot be null")
    private Integer bookId;

    @NotNull(message = "AvailableQuantity cannot be null")
    private Integer availableQuantity;

    @NotBlank(message = "Ratedr cannot be blank")
    @NotNull(message = "Ratedr cannot be null")
    @SafeTextValidator(message = "Improper xss script detected.")
    private String ratedr;

    @NotNull(message = "BorrowedQuantity cannot be null")
    private Integer borrowedQuantity;

    @NotNull(message = "ReservedQuantity cannot be null")
    private Integer reservedQuantity;

    @NotNull(message = "QuantityAvailableForLoan cannot be null")
    private Integer quantityAvailableForLoan;

    @NotNull(message = "AvailableOnDate cannot be null")
    private LocalDateTime availableOnDate;
}
