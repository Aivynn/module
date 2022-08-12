package com.utils;

public class WrongCSVFileReadingException extends RuntimeException {

    public WrongCSVFileReadingException() {
    }

    public WrongCSVFileReadingException(final String message) {
        super(message);
    }

}
