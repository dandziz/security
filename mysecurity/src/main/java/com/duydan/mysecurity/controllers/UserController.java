package com.duydan.mysecurity.controllers;

import com.duydan.mysecurity.dto.requests.user.SaveUserRequest;
import com.duydan.mysecurity.entities.Role;
import com.duydan.mysecurity.entities.User;
import com.duydan.mysecurity.services.RoleService;
import com.duydan.mysecurity.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody SaveUserRequest user) {
        return userService.save(user);
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

}
