package br.marcos.core.domain.exceptions.enums;

public enum ErroCodeEnum {

    ON001("Tax Number is invalid", "0001"),
    TR0001("User shokepeer transfer is unvailible", "0001"),
    TR0002("amount is indisponible", "0002"),
    TRP001("Pin is invalid", "0001"),

    ;
    private String message;
    private String code;

    ErroCodeEnum(String message, String code) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
