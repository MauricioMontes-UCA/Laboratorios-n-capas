package org.example.laboratorio3.domain.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class APIErrorResponse {
    private Object message;
    private int status;
    private LocalDateTime time;
    private String uri;
}
