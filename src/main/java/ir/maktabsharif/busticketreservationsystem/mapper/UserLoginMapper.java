package ir.maktabsharif.busticketreservationsystem.mapper;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserLoginMapper {
    public User toEntity(LoginDto loginDto) {
        User user = User.builder()
                .username(loginDto.username())
                .password(loginDto.password())
                .build();
        return user;
    }

    public LoginResponseDto toDto(User user) {
        return new LoginResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
