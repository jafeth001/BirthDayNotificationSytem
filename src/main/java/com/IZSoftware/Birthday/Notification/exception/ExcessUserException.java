package com.IZSoftware.Birthday.Notification.exception;

public class ExcessUserException  extends Exception{
    public ExcessUserException() {
        super();
    }

    public ExcessUserException(String message) {
        super(message);
    }

    public ExcessUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcessUserException(Throwable cause) {
        super(cause);
    }

    protected ExcessUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
