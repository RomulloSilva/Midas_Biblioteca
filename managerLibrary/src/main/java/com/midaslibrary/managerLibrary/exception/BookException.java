package com.midaslibrary.managerLibrary.exception;

public class BookException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public BookException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public BookException(String msg) {
    }
}
