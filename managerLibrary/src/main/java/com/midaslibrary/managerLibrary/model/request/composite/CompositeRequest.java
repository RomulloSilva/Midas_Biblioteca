package com.midaslibrary.managerLibrary.model.request.composite;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompositeRequest implements Serializable {
    private static final long serialVersionUID = 822826257966512285L;

    private String url;
    private String method;
    private Object object;
}
