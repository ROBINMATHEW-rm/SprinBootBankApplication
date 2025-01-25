package com.springbootblogapplication.Spring.Boot.Blog.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    private List<Account> accounts;
    @ManyToMany
    private Set<Role> roleSet;
}
