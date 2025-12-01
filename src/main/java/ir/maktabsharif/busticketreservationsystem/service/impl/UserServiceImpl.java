package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_ROLE;
import ir.maktabsharif.busticketreservationsystem.dto.UserRegisterDto;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.UserService;
import ir.maktabsharif.busticketreservationsystem.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private User user;

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }


    @Override
    public User register(UserRegisterDto userRegisterDto) {
        if (userRegisterDto.username() == null || userRegisterDto.password() == null) {
            throw new RuntimeException("Required Fields missing null");
        }
        if (userRepository.findByUsername(userRegisterDto.username()).isPresent()) {
            throw new RuntimeException("username is exist, please choose another username");
        }
        if (user.getUserRole() == USER_ROLE.ADMIN_ROLE) {
            System.out.println(user.getUserRole());
        } else if (user.getUserRole() == USER_ROLE.USER_ROLE) {
            System.out.println(user.getUserRole());
        } else if (user.getUserRole() == USER_ROLE.COMPANY_ROLE) {
            System.out.println(user.getUserRole());
        }
        String hashedPassword = PasswordUtil.encode(userRegisterDto.password());
        User user = User.builder()
                .username(userRegisterDto.username())
                .password(hashedPassword)
                .email(userRegisterDto.email())
                .build();
        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        if (username == null || password == null) {
            throw new RuntimeException("Invalid username or password");
        }

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("invalid username"));

        if (!PasswordUtil.verify(password, user.getPassword())) {
            throw new RuntimeException("invalid password");
        }
        return user;
    }

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
