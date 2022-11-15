package com.helpmate.helpmate.repository;

import com.helpmate.helpmate.entity.Role;
import com.helpmate.helpmate.entity.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByRoleType(RoleType roleType);
}
