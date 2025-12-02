package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserChangeStatusDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserChangeStatusResponseDto;
import ir.maktabsharif.busticketreservationsystem.mapper.UserChangeStatusMapper;
import ir.maktabsharif.busticketreservationsystem.service.UserChangeStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserChangeStatusController {
    private final UserChangeStatus userChangeStatus;
    private final UserChangeStatusMapper userChangeStatusMapper;


    @PostMapping("/change-status")
    public ResponseEntity<UserChangeStatusResponseDto> changeStatus(@RequestBody UserChangeStatusDto userChangeStatusDto) {
        User entity = userChangeStatus.userChangeStatus(userChangeStatusDto.userId());
        UserChangeStatusResponseDto response = userChangeStatusMapper.toResponseDto(entity);
        return ResponseEntity.ok(response);
    }
}
