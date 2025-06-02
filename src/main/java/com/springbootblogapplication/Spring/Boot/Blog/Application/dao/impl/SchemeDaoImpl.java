package com.springbootblogapplication.Spring.Boot.Blog.Application.dao.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dao.SchemeDao;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.query.SchemeQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class SchemeDaoImpl implements SchemeDao {
    private final JdbcTemplate jdbcTemplate;

    public SchemeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void createSchemeData(SchemeData schemeData){
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement=con.prepareStatement(SchemeQuery.INSERT_SCHEME_DATA);
            int paraIndex =1;
            preparedStatement.setString(paraIndex++,schemeData.getSchemeName());
            preparedStatement.setString(paraIndex++,schemeData.getDescription());
            return preparedStatement;
        });
    }
}
