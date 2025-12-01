package ir.maktabsharif.busticketreservationsystem.service;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;

public interface BaseUserService {
    User register(RegisterDto registerDto);
    User login(LoginDto loginDto);
}
