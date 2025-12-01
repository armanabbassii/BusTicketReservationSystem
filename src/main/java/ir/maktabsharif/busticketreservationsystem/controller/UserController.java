package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.AdminRegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.AdminResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserRegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.UserResponseDto;
import ir.maktabsharif.busticketreservationsystem.mapper.UserMapper;
import ir.maktabsharif.busticketreservationsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @PostMapping("/user/register")
    public ResponseEntity<UserResponseDto> register(
            @RequestBody UserRegisterDto userRegisterDto) {
        User entity = userService.register(userRegisterDto);
        UserResponseDto response = userMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<AdminResponseDto> register(
            @RequestBody AdminRegisterDto adminRegisterDto) {
        User entity = userService.register(adminRegisterDto);
        AdminResponseDto response = adminMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
