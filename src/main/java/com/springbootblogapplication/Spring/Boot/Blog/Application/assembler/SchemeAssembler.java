package com.springbootblogapplication.Spring.Boot.Blog.Application.assembler;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import org.springframework.stereotype.Component;

@Component
public class SchemeAssembler {
    public SchemeData assembleCreateSchemeData(SchemeData schemeData){
        return SchemeData.builder()
                .schemeName(schemeData.getSchemeName())
                .description(schemeData.getDescription())
                .build();
    }
}
