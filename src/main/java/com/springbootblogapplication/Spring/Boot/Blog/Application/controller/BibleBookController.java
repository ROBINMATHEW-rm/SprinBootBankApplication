package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.BibleBookDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.conversion.BibleBookConversion;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.BibleBook;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.BibleBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BibleBookController {
    @Autowired
    private BibleBookService bibleBookService;
    @Autowired
    private BibleBookConversion bibleBookConversion;
    @GetMapping
    public List<BibleBookDto> getAllBooks() {
        List<BibleBook> bibleBooks = bibleBookService.getAllBooks();
        return bibleBookConversion.toDtoList(bibleBooks);
    }
}


