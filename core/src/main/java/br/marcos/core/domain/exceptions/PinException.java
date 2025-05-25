package br.marcos.core.domain.exceptions;


public class PinException extends Exception {
    private String code;

    public PinException(String message, String code) {
        super(message);
        this.code = code;
    }
}
