package com.duydan.mysecurity.serviceImpls;

import com.duydan.mysecurity.dto.requests.user.SaveUserRequest;
import com.duydan.mysecurity.entities.Role;
import com.duydan.mysecurity.entities.User;
import com.duydan.mysecurity.repositories.RoleRepository;
import com.duydan.mysecurity.repositories.UserRepository;
import com.duydan.mysecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(SaveUserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .enabled(userRequest.getEnabled())
                .departmentId(userRequest.getDepartmentId())
                .build();
        Role userRole = roleRepository.findByName("USER");
        //if (userRole == null)   userRole = roleRepository.save(new Role("USER"));
        //user.setRoles(List.of(userRole));
        user = userRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
