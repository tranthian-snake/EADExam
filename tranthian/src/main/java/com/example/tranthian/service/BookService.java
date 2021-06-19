package com.example.tranthian.service;

import com.example.tranthian.entity.Book;
import com.example.tranthian.entity.Publisher;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> getBookByPublisher(String name, Pageable pageable);
    List<Book> getAllBook(Pageable pageable);
    Book createBook(Book book);
    int getTotalPage(Pageable pageable);
    List<Publisher> getAllPublisher(Pageable pageable);
    Publisher createPublisher(Publisher publisher);
}
