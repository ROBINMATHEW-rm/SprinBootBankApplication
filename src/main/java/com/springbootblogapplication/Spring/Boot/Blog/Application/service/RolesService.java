package com.springbootblogapplication.Spring.Boot.Blog.Application.service;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.RoleDto;

public interface RolesService {

    RoleDto roleAdd(RoleDto roleDto);

    RoleDto roleUpdate(long id, RoleDto roleDto);

    RoleDto roleGetSingle(long id);

    RoleDto removeRole(long id);
}
