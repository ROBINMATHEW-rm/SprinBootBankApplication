package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.BibleBook;
import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.BibleBookRepository;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.BibleBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplService implements BibleBookService {
    private final BibleBookRepository bibleBookRepository;
    public BookServiceImplService(BibleBookRepository bibleBookRepository) {
        this.bibleBookRepository = bibleBookRepository;
    }
    @Override
    public List<BibleBook> getAllBooks() {
        return bibleBookRepository.findAll();
    }
}
