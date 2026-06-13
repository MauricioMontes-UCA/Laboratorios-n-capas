package com.server.app.services;

import com.server.app.config.JsonWebToken;
import com.server.app.dto.auth.LoginDto;
import com.server.app.dto.auth.SignupDto;
import com.server.app.dto.response.LoginResponseDto;
import com.server.app.dto.mappers.UserMapper;
import com.server.app.dto.user.UserCreateDto;
import com.server.app.entities.User;
import com.server.app.exceptions.NotFoundException;
import com.server.app.exceptions.UnauthorizedException;
import com.server.app.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JsonWebToken jsonWebToken;

    @Transactional(readOnly = true)
    public LoginResponseDto login(LoginDto dto) {
        User user = userRepository.findUserByUsername(dto.getUsername())
                .orElseThrow(() -> new NotFoundException("Usuario o contraseña inválidos"));

        if (user.isBlocked()) {
            throw new UnauthorizedException("El usuario está bloqueado");
        }

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UnauthorizedException("Usuario o contraseña inválidos");
        }
         String token = jsonWebToken.createToken(user);

         return LoginResponseDto.builder()
                 .token(token)
                 .data(UserMapper.toDto(user))
                 .build();
     }

    @Transactional
    public LoginResponseDto signup(SignupDto dto) {
        UserCreateDto userCreateDto = new UserCreateDto();
        userCreateDto.setUsername(dto.getUsername());
        userCreateDto.setName(dto.getName());
        userCreateDto.setSurname(dto.getSurname());
        userCreateDto.setEmail(dto.getEmail());
        userCreateDto.setPassword(dto.getPassword());
        userCreateDto.setRole(1L); // ID del rol de ADMIN

        User user = userService.create(userCreateDto);

        String token = jsonWebToken.createToken(user);

        return LoginResponseDto.builder()
                .token(token)
                .data(UserMapper.toDto(user))
                .build();
    }
}

