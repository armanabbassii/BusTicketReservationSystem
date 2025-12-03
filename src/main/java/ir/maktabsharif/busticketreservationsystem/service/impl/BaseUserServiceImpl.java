package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.BaseUserService;
import ir.maktabsharif.busticketreservationsystem.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseUserServiceImpl implements BaseUserService {
    private final UserRepository userRepository;

    @Override
    public User login(LoginDto loginDto) {
        if (loginDto.username() == null || loginDto.password() == null) {
            throw new RuntimeException("Invalid username or password");
        }

        User user = userRepository.findByUsername(loginDto.username())
                .orElseThrow(() -> new RuntimeException("invalid username"));

        if (!PasswordUtil.verify(loginDto.password(), user.getPassword())) {
            throw new RuntimeException("invalid password");
        }
        return user;
    }

    @Override
    public User register(RegisterDto registerDto) {
        if (registerDto.username() == null || registerDto.password() == null) {
            throw new RuntimeException("Required Fields missing null");
        }
        if (userRepository.findByUsername(registerDto.username()).isPresent()) {
            throw new RuntimeException("username is exist, please choose another username");
        }

        String hashedPassword = PasswordUtil.encode(registerDto.password());
        return User.builder()
                .username(registerDto.username())
                .password(hashedPassword)
                .email(registerDto.email())
                .build();
    }
}
