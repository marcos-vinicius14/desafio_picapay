package br.com.marcos.usecase;

import javax.naming.AuthenticationException;

public interface UserAuthenticateCase {
    Boolean isAuthenticate(String username, String password) throws AuthenticationException;
}
