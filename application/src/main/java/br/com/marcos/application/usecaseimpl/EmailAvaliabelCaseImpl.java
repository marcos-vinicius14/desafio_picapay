package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.EmailAvalibleGateway;
import br.com.marcos.usecase.EmailAvaliableCase;

public class EmailAvaliabelCaseImpl implements EmailAvaliableCase {
    private final EmailAvalibleGateway emailAvalibleGateway;

    public EmailAvaliabelCaseImpl(EmailAvalibleGateway emailAvalibleGateway) {
        this.emailAvalibleGateway = emailAvalibleGateway;
    }

    @Override
    public Boolean isEmailValid(String email) {
        return emailAvalibleGateway.isEmailValid(email);
    }
}
