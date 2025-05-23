package br.marcos.core.domain.exceptions;

public class InternalServerErrorExcetion extends Exception{
    private String code;
    public InternalServerErrorExcetion(String message, String code) {
        super(message);
        this.code = code;
    }
}
