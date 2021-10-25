package com.envioemail.producerfila.model.requests.build;

import com.envioemail.producerfila.exception.BuildCompositeException;
import com.envioemail.producerfila.model.entitys.LoanEntity;
import com.envioemail.producerfila.model.entitys.UsersEntity;
import com.envioemail.producerfila.model.requests.composite.CompositeRequest;
import com.envioemail.producerfila.model.requests.composite.user.Loan;
import com.envioemail.producerfila.model.requests.composite.user.User;
import com.envioemail.producerfila.model.requests.translator.LoanTranslator;
import com.envioemail.producerfila.model.requests.translator.UserTranslator;
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
