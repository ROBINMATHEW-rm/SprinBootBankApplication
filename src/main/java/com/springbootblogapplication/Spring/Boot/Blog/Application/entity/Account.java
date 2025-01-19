package com.springbootblogapplication.Spring.Boot.Blog.Application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String accountNumber;
    private double balance;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList;
}
