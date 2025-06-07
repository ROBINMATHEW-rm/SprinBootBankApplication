package com.springbootblogapplication.Spring.Boot.Blog.Application.dao.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dao.SchemeDao;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.mapper.SchemeRowMapper;
import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.DataNotFoundException;
import com.springbootblogapplication.Spring.Boot.Blog.Application.query.SchemeQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

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
    @Override
    public List<SchemeData> getAllSchemeData(){
        String sql=SchemeQuery.GET_ALL_SCHEME_DATA;
        List<SchemeData> res = jdbcTemplate.query(sql,new SchemeRowMapper());
        return res.isEmpty() ? null : res;
    }
    @Override
    public SchemeData getSchemeData(String schemeName){
        int numRows = getNumRowsSchemeName(schemeName);
        if(numRows == 0) {
          throw new DataNotFoundException(ApplicationConstants.NO_SCHEME_DATA_FOUND_MESSAGE);
        }else {
            String sql = SchemeQuery.GET_SCHEME_DATA;
            List<SchemeData> res = jdbcTemplate.query(sql, new SchemeRowMapper(), schemeName);
            return res.get(0);
        }
    }
    @Override
    public String deleteSchemeData(String schemeName){
        int numRows = getNumRowsSchemeName(schemeName);
        if(numRows == 0) {
            throw new DataNotFoundException(ApplicationConstants.NO_SCHEME_DATA_FOUND_MESSAGE);
        }else {
            String sql = SchemeQuery.DELETE_SCHEME_DATA;
            int res = jdbcTemplate.update(sql,new Object[]{schemeName});
            if(res !=0){
                return ApplicationConstants.DATA_DELETE_SUCCESS;
            }
            else{
                throw new DataNotFoundException(ApplicationConstants.DATA_DELETE_FAILED);
            }
        }
    }

    public int getNumRowsSchemeName(String schemeName){
        String sql = SchemeQuery.GET_SCHEME_ROW_DATA;
        return jdbcTemplate.queryForObject(sql,new Object[]{schemeName},Integer.class);
    }
}
