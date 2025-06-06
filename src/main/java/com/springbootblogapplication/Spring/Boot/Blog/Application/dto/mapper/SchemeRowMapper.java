package com.springbootblogapplication.Spring.Boot.Blog.Application.dto.mapper;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SchemeRowMapper implements RowMapper<SchemeData> {
    @Override
    public SchemeData mapRow(ResultSet rs, int rowNum) throws SQLException {
        SchemeData schemeData = new SchemeData();
        schemeData.setSchemaId(rs.getInt(1));
        schemeData.setSchemeName(rs.getString(2));
        schemeData.setDescription(rs.getString(3));
        return schemeData;
    }
}
