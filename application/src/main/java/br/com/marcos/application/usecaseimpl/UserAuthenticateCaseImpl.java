package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.UserAuthenticateGateway;
import br.com.marcos.usecase.UserAuthenticateCase;

import javax.naming.AuthenticationException;

public class UserAuthenticateCaseImpl implements UserAuthenticateCase {
    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticateCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean isAuthenticate(String username, String password) throws AuthenticationException {
        if (!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticationException();
        }

        return true;
    }
}
