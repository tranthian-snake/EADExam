package com.example.tranthian.controller;

import com.example.tranthian.entity.Book;
import com.example.tranthian.entity.Publisher;
import com.example.tranthian.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    BookService bookService;

    @GetMapping({"/", "/index"})
    public String index() { return "index"; }

    @GetMapping("/list_publisher")
    public String list_publisher(Model model,  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Publisher> publishers = bookService.getAllPublisher(PageRequest.of(page, size));
        int totalPage  = bookService.getTotalPage(PageRequest.of(page, size));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("publishers", publishers);
        return "listpublisher";
    }
    @GetMapping("/list_book")
    public String list_book(Model model,  @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Book> books = bookService.getAllBook(PageRequest.of(page, size));
        int totalPage  = bookService.getTotalPage(PageRequest.of(page, size));
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("size", size);
        model.addAttribute("page", page);
        model.addAttribute("books", books);
        return "listbook";
    }

    @GetMapping("/add_publisher")
    public String add_publisher(Model model) {
        Publisher publisher=new Publisher();
        model.addAttribute("publisher", publisher);
        return "addpublisher";
    }

    @PostMapping("/add_publisher")
    public String add_publisher(@ModelAttribute Publisher publisher, Model model) {
        bookService.createPublisher(publisher);
        return "redirect:/";
    }

    @GetMapping("/add_book")
    public String add_book(Model model) {
        Book book=new Book();
        model.addAttribute("book", book);
        return "addbook";
    }

    @PostMapping("/add_book")
    public String add_book(@ModelAttribute Book book, Model model) {
        bookService.createBook(book);
        return "redirect:/";
    }

}
