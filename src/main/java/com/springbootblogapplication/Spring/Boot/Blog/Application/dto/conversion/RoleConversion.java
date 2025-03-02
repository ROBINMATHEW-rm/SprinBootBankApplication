package com.springbootblogapplication.Spring.Boot.Blog.Application.dto.conversion;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.RoleDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleConversion {
    public Role dtoToEntity(RoleDto roleDto){
        Role role = new Role();
        role.setRoleName(roleDto.getRoleName());
        return role;
    }
    public RoleDto entityToDto(Role role){
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleName(role.getRoleName());
        return roleDto;
    }
    public List<RoleDto> toDtoList(List<Role> roles){
        return roles.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
