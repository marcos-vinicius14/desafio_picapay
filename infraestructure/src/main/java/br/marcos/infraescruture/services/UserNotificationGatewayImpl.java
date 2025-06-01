package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.UserNotificationGateway;
import br.marcos.core.domain.Transaction;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway {
    @Override
    public Boolean notificate(Transaction transaction, String email) {
        return true;
    }
}
