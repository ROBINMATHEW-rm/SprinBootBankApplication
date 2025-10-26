package com.springbootblogapplication.Spring.Boot.Blog.Application.dto.conversion;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.BibleBookDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.BibleBook;

import java.util.List;
import java.util.stream.Collectors;

public class BibleBookConversion {
    public BibleBookDto entityToDto(BibleBook bibleBook){
        BibleBookDto bibleBookDto = new BibleBookDto();
        bibleBookDto.setId(bibleBook.getId());
        bibleBookDto.setName(bibleBook.getName());
        bibleBookDto.setAbbreviation(bibleBook.getAbbreviation());
        bibleBookDto.setOrderIndex(bibleBook.getOrderIndex());
        return bibleBookDto;
    }
    public List<BibleBookDto> toDtoList(List<BibleBook> bibleBooks){
        return bibleBooks.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
