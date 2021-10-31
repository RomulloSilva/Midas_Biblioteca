package com.midaslibrary.managerLibrary.model.request.composite;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserRequest implements Serializable {

    private static final long serialVersionUID = -3468400510624366597L;
    private Integer userID;
    private Boolean userSituation;
    private List<CompositeRequest> user;
}
