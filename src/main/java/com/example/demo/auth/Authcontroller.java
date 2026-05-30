package com.example.demo.auth;

import com.example.demo.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username,
                                      @RequestParam String password) {

        Map<String, String> response = new HashMap<>();

        if ("admin".equals(username) && "admin123".equals(password)) {

            String token = jwtUtil.generateToken(username);

            response.put("token", token);
            response.put("role", "ADMIN");
            response.put("username", username);   // ✅ ADD THIS LINE

            return response;
        }

        response.put("error", "Invalid credentials");
        return response;
    }
}