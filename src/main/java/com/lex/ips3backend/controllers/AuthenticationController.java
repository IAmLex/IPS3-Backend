package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.User;
import com.lex.ips3backend.services.JwtTokenService;
import com.lex.ips3backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {
    final private JwtTokenService _jwtTokenService;
    final private UserService _userService;

    public AuthenticationController(JwtTokenService jwtTokenService, UserService userService) {
        this._jwtTokenService = jwtTokenService;
        this._userService = userService;
    }

    @PostMapping("/login")
    public Token login(@RequestBody User user) {
        User selectedUser = this._userService.getByEmailAndPassword(user);

        String token = null;
        if (selectedUser != null) {
            token = this._jwtTokenService.createToken(selectedUser);

            return new Token(token, selectedUser.getId());
        }
        return null;
    }
}

class Token {
    public Integer userId;
    public String token;

    public Token(String token, Integer userId) {
        this.token = token;
        this.userId = userId;
    }
}
