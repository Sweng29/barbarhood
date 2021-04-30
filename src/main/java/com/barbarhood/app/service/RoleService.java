package com.barbarhood.app.service;

import com.barbarhood.app.constants.RoleConstant;
import com.barbarhood.app.dto.RoleDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface RoleService {

    RoleDTO findRoleById(Long roleId);
    RoleDTO findRoleByRoleConstant(RoleConstant roleConstant);
    List<RoleDTO> findAllRoles();
    ResponseEntity<String> softDeleteRole(Long userId);
}
