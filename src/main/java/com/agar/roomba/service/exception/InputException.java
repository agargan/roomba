package com.agar.roomba.service.exception;

/**
 * Request payload input exception class
 */
public class InputException extends Exception {

    public InputException(String message) {
        super(message);
    }

    public InputException(Throwable throwable) {
        super(throwable);
    }
}
