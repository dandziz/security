package com.duydan.mysecurity.serviceImpls;

import com.duydan.mysecurity.entities.Role;
import com.duydan.mysecurity.repositories.RoleRepository;
import com.duydan.mysecurity.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
