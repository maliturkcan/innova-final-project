package com.kredi.innova.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException {

    private String message=null;

    public EntityNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}