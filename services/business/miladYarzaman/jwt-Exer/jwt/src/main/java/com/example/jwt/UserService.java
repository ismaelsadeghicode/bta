package com.example.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;
    public void save(@Valid  RegisterRequestDto user) {
        User user1=new User()
                .setUserName(user.getUserName())
                .setPassword(passwordEncoder.encode(user.getPassword()))
                .setEmail(user.getEmail());
        userRepository.save(user1);
    }
    public AuthResponseDto login(LoginRequestDto loginRequestDto){
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getUserName(),loginRequestDto.getPassword()));
        UserDetails userDetails=userDetailsService.loadUserByUsername(loginRequestDto.getUserName());
        String token=jwtProvider.generateToken(userDetails);
        return new AuthResponseDto().setToken(token).setUserName(userDetails.getUsername());

    }
}
