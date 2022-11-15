package com.helpmate.helpmate.initials;

import com.helpmate.helpmate.entity.Role;
import com.helpmate.helpmate.entity.enums.RoleType;
import com.helpmate.helpmate.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InitApp implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

//        Role userRole = new Role();
//        userRole.setId(1L);
//        userRole.setRoleType(RoleType.USER);
//        roleRepository.save(userRole);

    }
}
