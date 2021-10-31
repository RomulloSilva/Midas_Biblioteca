package com.midaslibrary.managerLibrary.exception;

public class PayloadUserException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public PayloadUserException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public PayloadUserException(String msg) {
    }
}
