package com.springbootblogapplication.Spring.Boot.Blog.Application.repository;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {
}
