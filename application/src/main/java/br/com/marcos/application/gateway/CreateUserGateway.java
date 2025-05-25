package br.com.marcos.application.gateway;

import br.marcos.core.domain.User;
import br.marcos.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
