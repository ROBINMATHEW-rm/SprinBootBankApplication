package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchemeData {
    private int schemaId;
    private String schemeName;
    private String  description;
}
