package com.envioemail.producerfila.exception;

public class LoanException extends RuntimeException {

    private static final long serialVersionUID = -4606867737808439375L;

    public LoanException(final String msg, final Throwable throwable) {
        super(msg, throwable);
    }

    public LoanException(String msg) {
    }
}
