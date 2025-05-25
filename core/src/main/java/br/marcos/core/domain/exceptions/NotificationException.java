package br.marcos.core.domain.exceptions;

public class NotificationException extends Exception {
    private String code;
    public NotificationException(String message, String code) {
        super(message);
        this.code = code;
    }
}
