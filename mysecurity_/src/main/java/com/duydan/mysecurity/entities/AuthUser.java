package com.duydan.mysecurity.entities;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class AuthUser extends org.springframework.security.core.userdetails.User {

    public AuthUser(final String userID, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
                    final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}
