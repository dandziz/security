package com.duydan.mysecurity.controllers;

import com.duydan.mysecurity.dto.requests.MapRequest;
import com.duydan.mysecurity.dto.requests.user.ChangePasswordRequest;
import com.duydan.mysecurity.entities.AuthUser;
import com.duydan.mysecurity.entities.User;
import com.duydan.mysecurity.dto.requests.LoginRequest;
import com.duydan.mysecurity.serviceImpls.AuthUserService;
import com.duydan.mysecurity.services.UserService;
import com.duydan.mysecurity.utils.JwtHelper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final UserService userService;
    private final AuthUserService authUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper helper;

    @GetMapping("/")
    public ResponseEntity<String> index(
            @RequestParam(required = false) @NotNull @Min(10) Integer age,
            @RequestParam(required = false) @NotNull @Min(10) Integer salary
    ) {
        return ResponseEntity.ok(age.toString());
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
        String token = this.helper.generateToken(userDetails);
        return token;
    }

    @PostMapping("/change-password")
    public String changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {

        return "";
    }

    @PostMapping("/map")
    public void map(@Valid @RequestBody MapRequest mapRequest) {

    }
}
