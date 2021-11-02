package com.midaslibrary.managerLibrary.exception;

public class BuildCompositeException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public BuildCompositeException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public BuildCompositeException(String msg) {
    }
}
