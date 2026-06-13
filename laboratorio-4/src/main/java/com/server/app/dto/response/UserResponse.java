package com.server.app.dto.response;

import com.server.app.entities.User;
import lombok.Builder;

@Builder
public record UserResponse(
        Integer id,
        String username,
        String name,
        String surname,
        String email,
        Object role
) {

}
