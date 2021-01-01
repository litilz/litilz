package com.ecommerce.repos.exception;

public class LitilException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LitilException() {
        super();
    }

    public LitilException(String message, Throwable cause) {
        super(message, cause);
    }

    public LitilException(String message) {
        super(message);
    }

    public LitilException(Throwable cause) {
        super(cause);
    }

}
