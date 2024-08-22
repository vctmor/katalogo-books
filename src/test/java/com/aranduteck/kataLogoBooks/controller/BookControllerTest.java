package com.aranduteck.kataLogoBooks.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.model.dto.BookDto;
import com.aranduteck.kataLogoBooks.service.BookService;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookControllerTest {

    private Book model;
    private BookController controller;
    private BookService service;
    private BookView view;
    private BookDto dto;
    private Reader reader;

    private String author = "Machado";
    private String title = "Capitu";

    @BeforeEach
    public void setUp(){
        
        // view = new BookView(dto);
        view = mock(BookView.class);
        // model = new Book(title, author);
        model = mock(Book.class);
        // service = new BookService(model);
        service = mock(BookService.class);
        controller = new BookController(service, view);
 
    }

    @Test
    public void getBorowTest(){

        
// 
        assertNull( controller.getBorowTo());

    }

}
