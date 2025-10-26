package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;
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
    @GetMapping
    public List<BibleBook> getAllBooks() {
        return bibleBookService.getAllBooks();
    }
}


