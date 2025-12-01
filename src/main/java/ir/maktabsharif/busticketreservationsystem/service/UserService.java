package ir.maktabsharif.busticketreservationsystem.service;


import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.UserRegisterDto;

import java.util.Optional;

public interface UserService extends BaseService<User, Long> {
    Optional<User> findByUsername(String username);
    User register(UserRegisterDto userRegisterDto);
    User login(String username, String password);
}
