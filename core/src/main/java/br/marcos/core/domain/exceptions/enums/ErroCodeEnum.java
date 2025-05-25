package br.marcos.core.domain.exceptions.enums;

public enum ErroCodeEnum {

    ON001("Tax Number is invalid", "0001"),
    ON002("Tax Number is unvaliable", "0002"),
    ON003("Email is unvaliable", "0003"),
    ON004("Internal Server Error", "0004"),

    TR0001("User shokepeer transfer is unvailible", "0001"),
    TR0002("amount is indisponible", "0002"),
    TR0003("Error! Transfer failed", "0003"),
    TR0004("Transfer Uhauthorized", "0004"),

    TRP001("Pin is invalid", "0001"),

    WA0001("Wallet not found", "0001"),

    NO0001("Erro while notifcate user", "0001"),

    ATH0001("Acess denied", "0001"),
    PIN0001("Pin is blocked", "0001"),


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
