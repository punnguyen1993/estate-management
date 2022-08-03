package com.laptrinhjavaweb.exception;

public class BuildingNotFoundException extends Exception {
    public BuildingNotFoundException() {
        super();
    }

    public BuildingNotFoundException(String message) {
        super(message);
    }

    public BuildingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildingNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BuildingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
