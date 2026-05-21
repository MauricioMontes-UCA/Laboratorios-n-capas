package org.example.laboratorio3.exceptions;

import org.example.laboratorio3.domain.dto.response.APIErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<APIErrorResponse> handleResourceNotFound(ResourceNotFoundException e) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }

    public ResponseEntity<APIErrorResponse> buildErrorResponse(HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();

        return ResponseEntity
                .status(status)
                .body(APIErrorResponse.builder()
                        .status(status.value())
                        .message(data)
                        .time(LocalDateTime.now())
                        .uri(uri)
                        .build()
                );
    }
}
