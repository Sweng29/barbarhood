package com.barbarhood.app.repository;

import com.barbarhood.app.constants.RoleConstant;
import com.barbarhood.app.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleConstant(RoleConstant roleConstant);
}