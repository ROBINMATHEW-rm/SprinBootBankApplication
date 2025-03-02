package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.RoleDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class RolesController {
    @Autowired
    private RolesService rolesService;
    @PostMapping("/role")
    public ResponseEntity<?> roleAdd(@RequestBody RoleDto roleDto){
        RoleDto result=rolesService.roleAdd(roleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/role/{id}")
    public ResponseEntity<?> roleUpdate(@PathVariable long id, @RequestBody RoleDto roleDto){
        RoleDto result=rolesService.roleUpdate(id, roleDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @GetMapping("/role/{id}")
    public ResponseEntity<?> getAddress(@PathVariable long id){
        RoleDto result=rolesService.roleGetSingle(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> getRemoveAddress(@PathVariable long id){
        RoleDto result=rolesService.removeRole(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
