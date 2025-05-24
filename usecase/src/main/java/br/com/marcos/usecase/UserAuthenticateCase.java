package br.com.marcos.usecase;

public interface UserAuthenticateCase {
    Boolean isAuthenticate(String username, String password);
}
