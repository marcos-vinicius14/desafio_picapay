package br.marcos.infraescruture;

import br.com.marcos.application.gateway.CreateUserGateway;
import br.com.marcos.application.gateway.EmailAvalibleGateway;
import br.com.marcos.application.gateway.TaxNumberAvalibleGateway;
import br.com.marcos.application.usecaseimpl.CreateUserCaseImpl;
import br.com.marcos.application.usecaseimpl.EmailAvaliabelCaseImpl;
import br.com.marcos.application.usecaseimpl.TaxNumberAvalibleCaseImpl;
import br.com.marcos.usecase.CreateUserCase;
import br.com.marcos.usecase.EmailAvaliableCase;
import br.com.marcos.usecase.TaxNumberAvaliableCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public TaxNumberAvaliableCase taxNumberAvaliableCase(TaxNumberAvalibleGateway taxNumberAvaliableGateway) {
        return new TaxNumberAvalibleCaseImpl(taxNumberAvaliableGateway);
    }

    @Bean
    public EmailAvaliableCase emailAvaliableCase(EmailAvalibleGateway emailAvaliableGateway) {
        return new EmailAvaliabelCaseImpl(emailAvaliableGateway);
    }

    @Bean
    public CreateUserCase createUserCase(TaxNumberAvaliableCase taxNumberAvaliableCase, EmailAvaliableCase emailAvaliableCase, CreateUserGateway createUserGateway) {
        return new CreateUserCaseImpl(taxNumberAvaliableCase, emailAvaliableCase, createUserGateway);
    }
}
