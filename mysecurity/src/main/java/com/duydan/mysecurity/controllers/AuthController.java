package com.duydan.mysecurity.controllers;

import com.duydan.mysecurity.entities.User;
import com.duydan.mysecurity.dto.requests.LoginRequest;
import com.duydan.mysecurity.exceptions.Exception;
import com.duydan.mysecurity.serviceImpls.AuthUserService;
import com.duydan.mysecurity.services.UserService;
import com.duydan.mysecurity.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthUserService authUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils helper;

    @GetMapping("/")
    public String index() throws Exception {
        return "Quá ngon";
    }

    @PostMapping(value = "/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = authUserService.loadUserByUsername(loginRequest.getUsername());
        return this.helper.generateToken(userDetails.getUsername());
    }
}
