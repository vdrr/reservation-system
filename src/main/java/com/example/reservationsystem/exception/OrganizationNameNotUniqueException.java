package com.example.reservationsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrganizationNameNotUniqueException extends RuntimeException {

    public OrganizationNameNotUniqueException(String msg) {
        super(msg);
    }
}
