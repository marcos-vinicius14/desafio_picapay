package br.marcos.core.domain.exceptions;

public class NotFoundException extends Exception {
    private String code;
    public NotFoundException(String message, String code) {
        super(message);
        this.code = message;
    }
}
