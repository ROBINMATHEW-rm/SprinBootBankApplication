package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.conversion.RoleConversion;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.RoleDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Role;
import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.DataNotFoundException;
import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.RoleRepo;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RolesService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RoleConversion roleConversion;
    @Override
    public RoleDto roleAdd(RoleDto roleDto){
        Role role=roleConversion.dtoToEntity(roleDto);
        Role result = roleRepo.save(role);
        return roleConversion.entityToDto(result);
    }
    @Override
    public RoleDto roleUpdate(long id, RoleDto roleDto){
        Role result = roleRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ROLE_DATA_FOUND_MESSAGE));
        result.setRoleName(roleDto.getRoleName());
        Role updatedResult=roleRepo.save(result);
        return roleConversion.entityToDto(updatedResult);
    }
    @Override
    public RoleDto roleGetSingle(long id){
        Role result = roleRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ROLE_DATA_FOUND_MESSAGE));
        return roleConversion.entityToDto(result);
    }
    @Override
    public RoleDto removeRole(long id){
        Role result = roleRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ROLE_DATA_FOUND_MESSAGE));
        roleRepo.deleteById(id);
        return roleConversion.entityToDto(result);
    }
}
