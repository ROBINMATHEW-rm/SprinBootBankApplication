package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BibleBookDto {
    private Long id;
    private String name;
    private String abbreviation;
    private Integer orderIndex;
}
