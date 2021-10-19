package com.envioemail.producerfila.config.model.constant;

public enum ResponseExceptionHandler {


    ERRO_NA_VALIDACAO_DE_CAMPOS("Erro na validacao de campos"),
    VALIDATION_ERROR("validation_error"),
    SERVICO_INDISPONIVEL("Servico Indisponivel"),
    RECURSO_INEXISTENTE("Recurso Inexistente"),
    ERRO_INESPERADO("Erro Inesperado");

    private String textoException;

    private ResponseExceptionHandler(String textoException) {
        this.textoException = textoException;
    }

    public String getTextoException() {
        return this.textoException;
    }
}
