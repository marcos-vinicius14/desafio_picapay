package br.marcos.core.domain.exceptions;

public class BadRequestException extends Exception {
    private String code;
    public BadRequestException(String message, String code) {
        super(message);
        this.code = code;
    }
}
