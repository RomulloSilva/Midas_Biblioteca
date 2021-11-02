package com.midaslibrary.managerLibrary.exception;

public class BookPropertiesException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public BookPropertiesException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public BookPropertiesException(String msg) {
    }
}
