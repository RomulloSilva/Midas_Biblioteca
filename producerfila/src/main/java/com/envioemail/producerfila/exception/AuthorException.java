package com.envioemail.producerfila.exception;

public class AuthorException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public AuthorException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public AuthorException(String msg) {
    }
}
