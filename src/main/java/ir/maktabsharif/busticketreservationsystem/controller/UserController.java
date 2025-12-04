package ir.maktabsharif.busticketreservationsystem.controller;

import ir.maktabsharif.busticketreservationsystem.domain.entity.User;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.LoginResponseDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.RegisterDto;
import ir.maktabsharif.busticketreservationsystem.dto.loginAndRegister.RegisterResponseDto;
import ir.maktabsharif.busticketreservationsystem.mapper.UserLoginMapper;
import ir.maktabsharif.busticketreservationsystem.mapper.UserRegisterMapper;
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
    private final UserRegisterMapper userRegisterMapper;
    private final UserLoginMapper userLoginMapper;
//region user register controller
    @PostMapping("/user/register")
    public ResponseEntity<RegisterResponseDto> registerUser(@RequestBody RegisterDto registerDto) {
        User entity = userService.registerUser(registerDto);
        RegisterResponseDto response = userRegisterMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    // user service: (abstract class)
    // admin service (impl) single - debugger
    // company service (impl)

    @PostMapping("/admin/register")
    public ResponseEntity<RegisterResponseDto> registerAdmin(@RequestBody RegisterDto registerDto) {
        User entity = userService.registerAdmin(registerDto);
        RegisterResponseDto response = userRegisterMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/company/register")
    public ResponseEntity<RegisterResponseDto> registerCompany(@RequestBody RegisterDto registerDto) {
        User entity = userService.registerCompany(registerDto);
        RegisterResponseDto response = userRegisterMapper.toDto(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
//endregion
//region user login controller
    @PostMapping("/user/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginDto loginDto){
        User entity = userService.loginUser(loginDto);
        LoginResponseDto response = userLoginMapper.toDto(entity);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<LoginResponseDto> loginAdmin(@RequestBody LoginDto loginDto){
        User entity = userService.loginAdmin(loginDto);
        LoginResponseDto response = userLoginMapper.toDto(entity);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/company/login")
    public ResponseEntity<LoginResponseDto> loginCompany(@RequestBody LoginDto loginDto){
        User entity = userService.loginCompany(loginDto);
        LoginResponseDto response = userLoginMapper.toDto(entity);
        return ResponseEntity.ok(response);
    }
    //endregion
}
