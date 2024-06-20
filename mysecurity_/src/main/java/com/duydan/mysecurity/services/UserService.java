package com.duydan.mysecurity.services;

import com.duydan.mysecurity.dto.requests.user.SaveUserRequest;
import com.duydan.mysecurity.entities.User;

import java.util.List;

public interface UserService {

    public User register(User user);
    public User save(SaveUserRequest userRequest);
    public List<User> getAllUsers();
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);

}
