package br.com.marcos.application.gateway;

import br.marcos.core.domain.Transaction;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
