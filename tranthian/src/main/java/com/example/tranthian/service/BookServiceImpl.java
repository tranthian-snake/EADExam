package com.example.tranthian.service;

import com.example.tranthian.entity.Book;
import com.example.tranthian.entity.Publisher;
import com.example.tranthian.repository.BookRepo;
import com.example.tranthian.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;

    @Autowired
    PublisherRepo publisherRepo;

    @Override
    public List<Book> getBookByPublisher(String name, Pageable pageable) {
        return bookRepo.findAllByPublisher(name, pageable);
    }

    @Override
    public List<Book> getAllBook(Pageable pageable) {
        return bookRepo.findAll(pageable).getContent();
    }

    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public int getTotalPage(Pageable pageable) {
        return bookRepo.findAll(pageable).getTotalPages();
    }

    @Override
    public List<Publisher> getAllPublisher(Pageable pageable) {
        return publisherRepo.findAll(pageable).getContent();
    }

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }
}
