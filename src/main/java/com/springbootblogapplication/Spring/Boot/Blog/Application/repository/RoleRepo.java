package com.springbootblogapplication.Spring.Boot.Blog.Application.repository;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
