package br.marcos.core.domain.exceptions;

public class TaxNumberException extends Exception {
    private String code;
    private String message;

    public TaxNumberException(String message, String code) {
        super(message);
        this.code = code;
    }
}
