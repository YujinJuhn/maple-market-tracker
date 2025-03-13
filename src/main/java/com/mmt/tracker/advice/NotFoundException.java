package com.mmt.tracker.advice;

public class NotFoundException extends TrackerGlobalException {

    public NotFoundException(String message) {
        super(message);
    }
}
