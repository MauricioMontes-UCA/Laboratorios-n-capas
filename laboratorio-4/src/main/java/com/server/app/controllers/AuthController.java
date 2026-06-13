package com.server.app.controllers;

import com.server.app.dto.auth.LoginDto;
import com.server.app.dto.auth.SignupDto;
import com.server.app.dto.mappers.UserMapper;
import com.server.app.dto.response.LoginResponseDto;
import com.server.app.dto.response.UserResponse;
import com.server.app.entities.User;
import com.server.app.services.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDto> signup(@Valid @RequestBody SignupDto dto) {
        return ResponseEntity.ok(authService.signup(dto));
    }

    @GetMapping("/profile")
    @Transactional
    public ResponseEntity<UserResponse> getProfile(@AuthenticationPrincipal User user) {
        try {
            UserResponse userResponse = UserMapper.toDto(user);
            return ResponseEntity.ok(userResponse);
        } catch (Exception e) {
            System.err.println("Error al obtener perfil: " + e.getMessage());
            throw e;
        }
    }
}

