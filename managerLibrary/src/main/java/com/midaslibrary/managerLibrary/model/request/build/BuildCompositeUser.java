package com.midaslibrary.managerLibrary.model.request.build;


import com.midaslibrary.managerLibrary.exception.BuildCompositeException;
import com.midaslibrary.managerLibrary.model.entities.LoanEntity;
import com.midaslibrary.managerLibrary.model.entities.UsersEntity;
import com.midaslibrary.managerLibrary.model.request.composite.CompositeRequest;
import com.midaslibrary.managerLibrary.model.request.composite.user.Loan;
import com.midaslibrary.managerLibrary.model.request.composite.user.User;
import com.midaslibrary.managerLibrary.model.request.translator.LoanTranslator;
import com.midaslibrary.managerLibrary.model.request.translator.UserTranslator;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class BuildCompositeUser {

    private static final String METHOD = "GET";
    private static final String URL = "http://localhost:8080/midasBiblioteca/user/%s/loans";
    private static final String MSG_ERRO = "User Composite generation failed: %s";

    public static CompositeRequest execute(UsersEntity usersEntity, List<LoanEntity> loanEntity) {

        try {
            List<Loan> loans = LoanTranslator.fromList(loanEntity);
            User user = UserTranslator.from(usersEntity, loans);

            return CompositeRequest.builder()
                    .method(METHOD)
                    .url(String.format(URL, usersEntity.getId()))
                    .object(user)
                    .build();
        } catch (Exception exception) {

            String menssage = String.format(MSG_ERRO, exception);
            log.error(menssage);
            throw new BuildCompositeException(menssage);

        }

    }
}
