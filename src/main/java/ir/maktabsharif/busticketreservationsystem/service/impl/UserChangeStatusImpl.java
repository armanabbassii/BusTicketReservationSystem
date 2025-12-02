package ir.maktabsharif.busticketreservationsystem.service.impl;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.domain.enums.USER_STATUS;
import ir.maktabsharif.busticketreservationsystem.exception.UserException;
import ir.maktabsharif.busticketreservationsystem.repository.UserRepository;
import ir.maktabsharif.busticketreservationsystem.service.UserChangeStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserChangeStatusImpl implements UserChangeStatus {
    private final UserRepository userRepository;

    @Override
    public User userChangeStatus(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("user not found"));

        if (user.getUserStatus() == USER_STATUS.DEACTIVATED) {
            user.setUserStatus(USER_STATUS.ACTIVATED);
        }
        return userRepository.save(user);
    }
}
