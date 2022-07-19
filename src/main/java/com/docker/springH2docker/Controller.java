package com.docker.springH2docker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    Repo bookRepo;

    @GetMapping("/home")
    public String home() {
        return "This is the home page";
    }

    // index
    @GetMapping("/")
    public List<Book> getAllBooks(){
        return (List<Book>)bookRepo.findAll();
    }

    // create
    @PostMapping("/")
    public Book createBook(@RequestBody Book book){
        Book savedBook = bookRepo.save(book);
        System.out.println(savedBook);
        return savedBook;
    }

    // read
    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookRepo.findById(id).get();
    }

    // update
    @PutMapping("/")
    public Book updateBook(@RequestBody Book book){
        int id = book.getId();
        Book b = bookRepo.findById(id).get();
        
        b.setName(book.getName());
        Book updatedBook = bookRepo.save(b);

        System.out.println(updatedBook);
        return updatedBook;
    }

    // delete
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        System.out.println("Deleting book with id: " + id);
        bookRepo.deleteById(id);
        return "Deleted";
    }

}
