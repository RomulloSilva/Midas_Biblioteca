package com.envioemail.producerfila.model.requests.payload;


import com.envioemail.producerfila.domain.interfaces.LoanValidation;
import com.envioemail.producerfila.domain.interfaces.UsersValidations;
import com.envioemail.producerfila.exception.PayloadUserException;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.model.requests.build.BuildCompositeUser;
import com.envioemail.producerfila.model.requests.composite.CompositeRequest;
import com.envioemail.producerfila.model.requests.composite.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        return usersValidations.execute(userId);
    }

    public List<LoanEntity> searchloans(Integer userId) {
        return loanValidation.findAllLoansByUser(userId);
    }

}
