package com.mmt.tracker.advice;

public class BadRequestException extends TrackerGlobalException {

    private static final String MESSAGE = "잘못된 요청입니다.";

    public BadRequestException(String message) {
        super(message + " : " + BadRequestException.MESSAGE);
    }

}
