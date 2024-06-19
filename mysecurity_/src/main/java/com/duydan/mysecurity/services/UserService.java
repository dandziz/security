package com.duydan.mysecurity.services;

import com.duydan.mysecurity.entities.User;

import java.util.List;

public interface UserService {

    public User save(User user);
    public List<User> getAllUsers();
    public User findUserByUsername(String username);
    public User findUserByEmail(String email);

}
