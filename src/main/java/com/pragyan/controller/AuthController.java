package com.pragyan.controller;


import com.pragyan.entity.User;
import com.pragyan.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){ this.authService = authService; }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User u) {
        String token = authService.signup(u);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> req) {
        String token = authService.login(req.get("email"), req.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }


}
