package com.envioemail.producerfila.exception;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public UserException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public UserException(String msg) {
    }
}
