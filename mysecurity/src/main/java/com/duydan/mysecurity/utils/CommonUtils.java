package com.duydan.mysecurity.utils;

import com.duydan.mysecurity.entities.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chinna
 *
 */
public class CommonUtils {

    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final List<Role> userRoles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
