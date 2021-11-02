package com.midaslibrary.managerLibrary.config.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class MessageErroModel {

    private String code;
    private String message;

    @JsonInclude(Include.NON_NULL)
    private List<FieldErroMessageModel> fields;
}
