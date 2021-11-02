package com.midaslibrary.managerLibrary.exception.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Collection;

public class ErroResouce implements Serializable {
    private static final long serialVersionUID = 88290895811338180L;

    @ApiModelProperty(name = "codigo", dataType = "Integer", example = "400", required = true, notes = "Código Http de retorno")
    private final Integer codigo;
    @ApiModelProperty(name = "codigo", dataType = "string", example = "Ocorreu um erro", required = true, notes = "Texto descritivo do erro")
    private final String mensagem;

    private Collection<FieldErroResource> campos;

    public ErroResouce(Integer codigo, String mensagem) {

        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public ErroResouce(Integer codigo, String mensagem, Collection<FieldErroResource> campos) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.campos = campos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Collection<FieldErroResource> getCampos() {
        return campos;
    }
}