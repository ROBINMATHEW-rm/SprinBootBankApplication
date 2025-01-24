package com.springbootblogapplication.Spring.Boot.Blog.Application.repository;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
}
