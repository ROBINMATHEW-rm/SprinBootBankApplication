package com.springbootblogapplication.Spring.Boot.Blog.Application.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
@Value("${spring.datasource.url}")
 private  String url;
@Value("${spring.datasource.username}")
private  String userName;
@Value("${spring.datasource.password}")
private  String password;

@Bean
public DataSource getDataSource(Environment env){
   return DataSourceBuilder.create().driverClassName("com.mysql.cj.jdbc.Driver").
           url(url).
           username(userName).
           password(password).build();
}
@Bean
 public JdbcTemplate jdbcTemplate(Environment environment){
 return new JdbcTemplate(getDataSource(environment));
}
}
