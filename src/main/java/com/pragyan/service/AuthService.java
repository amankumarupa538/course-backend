package com.pragyan.service;


import com.pragyan.entity.User;
import com.pragyan.repository.UserRepository;
import com.pragyan.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthService(UserRepository userRepo, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepo = userRepo; this.passwordEncoder = passwordEncoder; this.jwtUtil = jwtUtil;
    }
    public String signup(User u) {
        if (userRepo.existsByEmail(u.getEmail())) throw new RuntimeException("Email exists");
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userRepo.save(u);
        return jwtUtil.generateToken(u.getEmail());
    }
    public String login(String email, String password) {
        var user = userRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(password,user.getPassword())) throw new RuntimeException("Invalid credentials");
        return jwtUtil.generateToken(user.getEmail());
    }
}
