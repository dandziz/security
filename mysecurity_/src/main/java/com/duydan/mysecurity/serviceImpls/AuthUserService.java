package com.duydan.mysecurity.serviceImpls;

import com.duydan.mysecurity.entities.AuthUser;
import com.duydan.mysecurity.entities.User;
import com.duydan.mysecurity.services.UserService;
import com.duydan.mysecurity.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {
    @Lazy
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        return createAuthUser(user);
    }

    private AuthUser createAuthUser(User user) {
        return new AuthUser(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, CommonUtils.buildSimpleGrantedAuthorities(user.getRoles()));
    }
}
