package com.aranduteck.kataLogoBooks.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.service.BookService;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookControllerTest {

    private Book model;
    private BookController controller;
    private BookService service;
    private BookView view;

    private String author = "Machado";
    private String title = "Capitu";

    public void setUp(){
        
        model = new Book(title, author);
        service = new BookService(model);
        controller = new BookController(service, view);
      
        // service = mock(BookService.class);
        // view = mock(BookView.class);
               
    }

    @Test
    public void getBorowTest(){

        Reader reader = mock(Reader.class);
// TODO: por que tá dando erro?
        assertNull( controller.getBorowTo());
    }
}
