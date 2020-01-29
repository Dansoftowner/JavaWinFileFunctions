package com.dansoftware.winfilefunctions.exception;

public final class UnsupportedOperatingSystemException extends RuntimeException {
    public UnsupportedOperatingSystemException() {
    }

    public UnsupportedOperatingSystemException(String message) {
        super(message);
    }

    public UnsupportedOperatingSystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedOperatingSystemException(Throwable cause) {
        super(cause);
    }
}