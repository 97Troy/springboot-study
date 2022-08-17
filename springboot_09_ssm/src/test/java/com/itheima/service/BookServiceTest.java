package com.itheima.service;

import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest()
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetById(){
        Book book = bookService.getById(7);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> bookList = bookService.getAll();
        System.out.println(bookList);
    }

}
