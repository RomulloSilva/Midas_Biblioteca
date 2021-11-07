package com.midaslibrary.managerLibrary.exception;

public class S3Exception extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public S3Exception(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public S3Exception(String msg) {
    }
}
