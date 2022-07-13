/*

======================= Comentado porque este código =======================
======================= Sólo puede ejecutarse una única vez =======================
======================= Para generar los roles y no quiero eliminarlo xD =======================

________________________________________


package ar.com.BackEndSpringboot.api.util;

import ar.com.BackEndSpringboot.api.security.enums.RoleName;
import ar.com.BackEndSpringboot.api.security.models.Role;
import ar.com.BackEndSpringboot.api.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService roleService;


    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
        Role roleUser = new Role(RoleName.ROLE_USER);
        roleService.save(roleAdmin);
        roleService.save(roleUser);
    }
}
*/
