package com.api.streaming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Video não encontrado ou não existe.")
public class NotFound extends RuntimeException {
    
}
