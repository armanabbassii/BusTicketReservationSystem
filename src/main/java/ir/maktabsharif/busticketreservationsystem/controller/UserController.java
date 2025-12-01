package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.AdminRegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.AdminResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.RegisterResponseDto;
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
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/user/register")
    public ResponseEntity<RegisterResponseDto> registerUser(
            @RequestBody RegisterDto registerDto) {
        User entity = userService.registerUser(registerDto);
        RegisterResponseDto response = userMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/admin/register")
    public ResponseEntity<RegisterResponseDto> registerAdmin(
            @RequestBody RegisterDto registerDto) {
        User entity = userService.registerAdmin(registerDto);
        RegisterResponseDto response = userMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/company/register")
    public ResponseEntity<RegisterResponseDto> registerCompany(
            @RequestBody RegisterDto registerDto) {
        User entity = userService.registerCompany(registerDto);
        RegisterResponseDto response = userMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
