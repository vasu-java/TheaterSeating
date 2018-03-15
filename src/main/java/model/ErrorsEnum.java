package model;

public enum ErrorsEnum {
    SPLIT("SPLIT","Call to split party"),
    CANT_HANDLE("CANT_HANDLE","Sorry, we can't handle your party");

    String errorCde;
    String errorDsc;

    ErrorsEnum(String errorCde, String errorDsc) {
        this.errorCde = errorCde;
        this.errorDsc = errorDsc;
    }

    public String getErrorCde() {
        return errorCde;
    }

    public String getErrorDsc() {
        return errorDsc;
    }
}
