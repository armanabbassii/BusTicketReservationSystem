package ir.maktabsharif.busticketreservationsystem.service;


import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;

import java.util.Optional;

public interface UserService extends BaseService<User, Long> {
    Optional<User> findByUsername(String username);
    User registerUser(RegisterDto registerDto);
    User registerAdmin(RegisterDto registerDto);
    User registerCompany(RegisterDto registerDto);

    User loginUser(LoginDto loginDto);
    User loginAdmin(LoginDto loginDto);
    User loginCompany(LoginDto loginDto);
}
