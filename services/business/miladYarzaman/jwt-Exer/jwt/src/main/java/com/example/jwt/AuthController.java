package com.example.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody  RegisterRequestDto user){

        userService.save(user);
        return ResponseEntity.ok("register is succesfuly.");
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody   LoginRequestDto loginRequestDto){

        return ResponseEntity.ok(userService.login(loginRequestDto));
    }

}
