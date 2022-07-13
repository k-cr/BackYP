package ar.com.BackEndSpringboot.api.security.service;

import ar.com.BackEndSpringboot.api.security.enums.RoleName;
import ar.com.BackEndSpringboot.api.security.models.Role;
import ar.com.BackEndSpringboot.api.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

    public void save (Role role){
        roleRepository.save(role);
    }
}
