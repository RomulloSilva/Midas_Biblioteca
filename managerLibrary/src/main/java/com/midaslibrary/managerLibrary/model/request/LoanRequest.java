package com.midaslibrary.managerLibrary.model.request;


import com.midaslibrary.managerLibrary.model.dto.LoanDto;
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
    private List<LoanDto> loanDtos;
}
