package ir.maktabsharif.busticketreservationsystem.mapper;


import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.UserRegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserRegisterDto userRegisterDto) {
        User user = User.builder()
                .username(userRegisterDto.username())
                .password(userRegisterDto.password())
                .email(userRegisterDto.email())
                .build();
        return user;
    }

    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}