package ir.maktabsharif.busticketreservationsystem.mapper;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.LoginResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserChangeStatusDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserChangeStatusResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserChangeStatusMapper {
    public UserChangeStatusResponseDto toResponseDto(User user) {
        return new UserChangeStatusResponseDto(
                user.getUserId(),
                user.getUsername(),
                user.getUserRole().name(),
                user.getUserStatus().name());
    }
}