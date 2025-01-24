package com.springbootblogapplication.Spring.Boot.Blog.Application.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
public DataSource dataSource(){
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setJdbcUrl(url);
    dataSource.setUsername(userName);
    dataSource.setPassword(password);
    return  dataSource;
}

}
