package com.api.streaming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Um erro ocorreu ao tentar salva seu arquivo.")
public class ErrorSave extends RuntimeException {
    
}
