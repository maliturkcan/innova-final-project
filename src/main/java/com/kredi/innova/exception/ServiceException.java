package com.kredi.innova.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ServiceException extends RuntimeException {
    private String message=null;
    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
}