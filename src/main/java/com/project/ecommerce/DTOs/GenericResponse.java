package com.project.ecommerce.DTOs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Getter
@Setter
public class GenericResponse {
    private LocalDateTime timeStamp;
    private String message;
    private HttpStatus status;
}
