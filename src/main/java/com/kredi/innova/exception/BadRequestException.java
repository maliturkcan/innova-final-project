package com.kredi.innova.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BadRequestException extends RuntimeException {
    private String message = null;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }
}