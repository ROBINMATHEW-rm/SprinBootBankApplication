package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
    private long roleId;
    private String roleName;
    private Set<User> users;
}
