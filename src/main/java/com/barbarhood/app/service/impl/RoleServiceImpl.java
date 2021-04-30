package com.barbarhood.app.service.impl;

import com.barbarhood.app.constants.RoleConstant;
import com.barbarhood.app.dto.RoleDTO;
import com.barbarhood.app.model.Role;
import com.barbarhood.app.repository.RoleRepository;
import com.barbarhood.app.service.RoleService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO findRoleById(Long roleId) {
        return RoleDTO.of(roleRepository.findById(roleId).orElse(null));
    }

    @Override
    public RoleDTO findRoleByRoleConstant(RoleConstant roleConstant) {
        return RoleDTO
                .of(roleRepository.findByRoleConstant(roleConstant)
                .orElse(null));
    }

    @Override
    public List<RoleDTO> findAllRoles() {
        List<RoleDTO> roleDTOList;
        List<Role> roleList = roleRepository.findAll();
        roleDTOList = roleList.stream().map(RoleDTO::of)
                .collect(Collectors.toList());
        return roleDTOList;
    }

    @Override
    public ResponseEntity<String> softDeleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElse(null);
        if (role == null)
            return ResponseEntity
                    .notFound()
                    .build();
        role.setIsActive(Boolean.FALSE);
        roleRepository.save(role);
        return ResponseEntity.ok("Role has been deactivated.");
    }
}
