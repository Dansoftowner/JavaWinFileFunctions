package com.dansoftware.winfilefunctions.exception;

public class UnsupportedFileFormatException extends RuntimeException {
    public UnsupportedFileFormatException() {
    }

    public UnsupportedFileFormatException(String message) {
        super(message);
    }

    public UnsupportedFileFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedFileFormatException(Throwable cause) {
        super(cause);
    }

    public UnsupportedFileFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
