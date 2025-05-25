package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.UserNotificationGateway;
import br.com.marcos.usecase.UserNotificationCase;
import br.marcos.core.domain.Transaction;

public class UserNotificationCaseImpl implements UserNotificationCase {
    private final UserNotificationGateway userNotificationGateway;

    public UserNotificationCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return userNotificationGateway.notificate(transaction, email);
    }
}
