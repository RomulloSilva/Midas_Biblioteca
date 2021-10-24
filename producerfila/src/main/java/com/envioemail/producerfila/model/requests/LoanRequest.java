package com.envioemail.producerfila.model.requests;

import com.envioemail.producerfila.model.dto.Loan;
import lombok.*;


import javax.validation.Valid;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

    @Valid
    private List<Loan> loans;
}
