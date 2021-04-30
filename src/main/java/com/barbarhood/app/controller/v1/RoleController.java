package com.barbarhood.app.controller.v1;

import com.barbarhood.app.constants.RoleConstant;
import com.barbarhood.app.controller.BaseController;
import com.barbarhood.app.dto.RoleDTO;
import com.barbarhood.app.service.RoleService;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/roles")
@Api(tags = {"Role controller"})
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role/{roleId}")
    public ResponseEntity<RoleDTO> findRoleById(
            @Valid
            @Min(value = 1,message = "Role id must be greater then 0")
            @PathVariable Long roleId)
    {
        return ResponseEntity.ok(roleService.findRoleById(roleId));
    }

    @GetMapping("/{roleConstant}")
    public ResponseEntity<RoleDTO> findRoleByRoleConstant(@PathVariable RoleConstant roleConstant)
    {
        return ResponseEntity.ok(roleService.findRoleByRoleConstant(roleConstant));
    }

    @GetMapping
    public List<RoleDTO> findAllRoles()
    {
        return roleService.findAllRoles();
    }

}
