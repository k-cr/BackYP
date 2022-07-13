package ar.com.BackEndSpringboot.api.security.repository;

import ar.com.BackEndSpringboot.api.security.enums.RoleName;
import ar.com.BackEndSpringboot.api.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role> findByRoleName(RoleName roleName);
}
