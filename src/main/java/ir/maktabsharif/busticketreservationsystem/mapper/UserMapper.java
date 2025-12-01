package ir.maktabsharif.busticketreservationsystem.mapper;


import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserRegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(RegisterDto registerDto) {
        User user = User.builder()
                .username(registerDto.username())
                .password(registerDto.password())
                .email(registerDto.email())
                .build();
        return user;
    }

    public RegisterResponseDto toDto(User user) {
        return new RegisterResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}