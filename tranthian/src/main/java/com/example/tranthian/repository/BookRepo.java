package com.example.tranthian.repository;

import com.example.tranthian.entity.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer>{
        @Query("select b from Book b where b.name like %:name%")
        List<Book> findAllByPublisher(String name, Pageable pageable);
}
