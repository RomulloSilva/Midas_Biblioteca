package com.envioemail.producerfila.exception.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class FieldErroResource implements Serializable {
    private static final long serialVersionUID = 3742688095408996870L;

    @ApiModelProperty(name = "codigo", dataType = "string", example = "evento", notes = "Texto descritivo referente ao campo com o erro")
    private final String campo;
    @ApiModelProperty(name = "codigo", dataType = "string", example = "O campo deve ser informado", notes = "Texto descritivo referente ao campo com o erro")
    private final String mensagem;

    public FieldErroResource(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
