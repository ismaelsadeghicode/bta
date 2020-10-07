package com.mapsa.springsecurity.service;

import com.mapsa.springsecurity.domain.Role;
import com.mapsa.springsecurity.domain.User;
import com.mapsa.springsecurity.dto.AuthResponse;
import com.mapsa.springsecurity.dto.LoginRequest;
import com.mapsa.springsecurity.dto.RegisterRequest;
import com.mapsa.springsecurity.repository.UserRepository;
import com.mapsa.springsecurity.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    public void register(RegisterRequest registerRequest){
        User user =new User().setUsername(registerRequest.getUsername()).setPassword(passwordEncoder.encode(registerRequest.getPassword()));
       ArrayList<Role> roles=new ArrayList<>();
       roles.add(Role.Admin);
        user.setRoles(roles);
        userRepository.save(user);
    }
    public AuthResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),loginRequest.getPassword()));
        UserDetails userDetails=userDetailsService.loadUserByUsername(loginRequest.getUsername());
        String token=jwtProvider.generateToken(userDetails);
        return new AuthResponse().setUsername(userDetails.getUsername()).setToken(token);
    }
}
