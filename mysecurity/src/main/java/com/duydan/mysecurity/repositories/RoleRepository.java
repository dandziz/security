package com.duydan.mysecurity.repositories;

import com.duydan.mysecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
