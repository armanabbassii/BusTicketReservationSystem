package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_ROLE;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_STATUS;
import ir.maktabsharif.busticketreservationsystem.dto.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.exception.UserException;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.BaseUserService;
import ir.maktabsharif.busticketreservationsystem.service.UserService;
import ir.maktabsharif.busticketreservationsystem.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BaseUserService baseUserService;


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
//region register
    @Override
    public User registerUser(RegisterDto registerDto) {
        User user = baseUserService.register(registerDto);
        user.setUserRole(USER_ROLE.USER_ROLE);
        user.setUserStatus(USER_STATUS.ACTIVATED);
        return userRepository.save(user);
    }

    @Override
    public User registerAdmin(RegisterDto registerDto) {
        User user = baseUserService.register(registerDto);
        user.setUserRole(USER_ROLE.ADMIN_ROLE);
        user.setUserStatus(USER_STATUS.ACTIVATED);
        return userRepository.save(user);
    }

    @Override
    public User registerCompany(RegisterDto registerDto) {
        User user = baseUserService.register(registerDto);
        user.setUserRole(USER_ROLE.COMPANY_ROLE);
        user.setUserStatus(USER_STATUS.DEACTIVATED);
        return userRepository.save(user);
    }
//endregion

//region login
    @Override
    public User loginUser(LoginDto loginDto) {
        User user = baseUserService.login(loginDto);
        if (user.getUserRole() != USER_ROLE.USER_ROLE) {
            throw new UserException("access denied");
        }
        if (user.getUserStatus() != USER_STATUS.ACTIVATED)
            throw new UserException("your account is not active");
        return user;
    }

    @Override
    public User loginAdmin(LoginDto loginDto) {
        User user = baseUserService.login(loginDto);
        if (user.getUserRole() != USER_ROLE.ADMIN_ROLE) {
            throw new UserException("access denied");
        }
        if (user.getUserStatus() != USER_STATUS.ACTIVATED)
            throw new UserException("your account is not active");
        return user;
    }

    @Override
    public User loginCompany(LoginDto loginDto) {
        User user = baseUserService.login(loginDto);
        if (user.getUserRole() != USER_ROLE.COMPANY_ROLE) {
            throw new UserException("access denied");
        }
        if (user.getUserStatus() != USER_STATUS.ACTIVATED)
            throw new UserException("your account is not active");
        return user;
    }
//endregion

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public User update(User entity, Long aLong) {
        return null;
    }
}
