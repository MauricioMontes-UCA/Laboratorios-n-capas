package org.example.laboratorio3.domain.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

@Data
@Builder
public class GeneralResponse {
    private String uri;
    private String message;
    private int status;
    private LocalDateTime time;
    private Object data;
}

