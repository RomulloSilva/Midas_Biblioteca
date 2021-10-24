package com.envioemail.producerfila.config.model.constant;

public enum ResponseExceptionHandler {


    ERRO_VALIDATION_FIELDS("Error in field validation"),
    VALIDATION_ERROR("validation_error"),
    UNAVAILABLE_SERVICE("Unavailable service"),
    RESOURCE_NON_EXISTENT("Non-existent resource"),
    ERROR_UNEXPECTED("Unexpected error");

    private String textException;

    private ResponseExceptionHandler(String textException) {
        this.textException = textException;
    }

    public String getTextException() {
        return this.textException;
    }
}
