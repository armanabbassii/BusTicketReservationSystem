package ir.maktabsharif.busticketreservationsystem.service;
import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.RegisterDto;

public interface BaseUserService {
    User register(RegisterDto registerDto);
    User login(LoginDto loginDto);
}
