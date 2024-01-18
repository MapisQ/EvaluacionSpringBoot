package org.adaschool.evaluacionspringboot.application.exception;

import org.adaschool.evaluacionspringboot.application.lasting.EMessage;
import org.springframework.http.HttpStatus;

public class BookingException extends Exception{

    private HttpStatus status;
    private String message;

    public BookingException(EMessage message) {
        this.status = message.getStatus();
        this.message = message.getMessage();
    }
}
