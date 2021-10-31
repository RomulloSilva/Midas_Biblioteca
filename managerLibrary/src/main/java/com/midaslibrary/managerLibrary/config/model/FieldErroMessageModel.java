package com.midaslibrary.managerLibrary.config.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FieldErroMessageModel {

    private String field;
    private String message;
}
