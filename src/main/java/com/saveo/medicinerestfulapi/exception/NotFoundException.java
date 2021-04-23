package com.saveo.medicinerestfulapi.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class NotFoundException extends RuntimeException{

    private String message;

    public NotFoundException(String message){
        super(message);
        this.message = message;
    }
}
