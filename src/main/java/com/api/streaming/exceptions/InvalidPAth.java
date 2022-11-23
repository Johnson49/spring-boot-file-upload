package com.api.streaming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Nome do arquivo é inválido.")
public class InvalidPAth extends RuntimeException {
    
}
