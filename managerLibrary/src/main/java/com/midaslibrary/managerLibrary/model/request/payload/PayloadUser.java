package com.midaslibrary.managerLibrary.model.request.payload;


import com.midaslibrary.managerLibrary.domain.interfaces.LoanValidation;
import com.midaslibrary.managerLibrary.domain.interfaces.UsersValidations;
import com.midaslibrary.managerLibrary.exception.PayloadUserException;
import com.midaslibrary.managerLibrary.model.entities.LoanEntity;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.build.BuildCompositeUser;
import com.midaslibrary.managerLibrary.model.request.composite.CompositeRequest;
import com.midaslibrary.managerLibrary.model.request.composite.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@AllArgsConstructor
@Component
public class PayloadUser {

    private static final String MSG_FAILURE = "User Payload Generation Fault: %s";

    private final UsersValidations usersValidations;
    private final LoanValidation loanValidation;


    public UserRequest geraPayloadUser(Integer userId) {

        UserRequest userRequest = new UserRequest();
        List<CompositeRequest> compositeRequests = new ArrayList<>();
        try {
            geraComposite(userId, compositeRequests);
            userRequest.setUserID(userId);
            userRequest.setUserSituation(true);
            userRequest.setUser(compositeRequests);
        } catch (Exception exception) {
            throw new PayloadUserException(String.format(MSG_FAILURE, exception));
        }
        return userRequest;
    }

    public void geraComposite(Integer userId, List<CompositeRequest> compositeRequests) {
        UsersEntity usersEntity;
        List<LoanEntity> loanEntities;
        try {
            usersEntity = searchUser(userId);
            loanEntities = searchloans(userId);
            compositeRequests.add(BuildCompositeUser.execute(usersEntity, loanEntities));
        } catch (Exception exception) {
            throw new PayloadUserException(String.format(MSG_FAILURE, exception));
        }
    }


    public UsersEntity searchUser(Integer userId) {
        UsersEntity usersEntity;

        usersEntity = usersValidations.execute(userId);
        if (nonNull(usersEntity)) {
            return usersEntity;
        } else {
            throw new PayloadUserException("User Not Found.");
        }
    }

    public List<LoanEntity> searchloans(Integer userId) {
        return loanValidation.findAllLoansByUser(userId);
    }

}
