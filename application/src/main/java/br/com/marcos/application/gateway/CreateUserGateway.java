package br.com.marcos.application.gateway;

import br.marcos.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
