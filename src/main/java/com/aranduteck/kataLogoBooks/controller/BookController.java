package com.aranduteck.kataLogoBooks.controller;

import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.service.BookService;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookController {

    private BookService service;
    private BookView view;

    public BookController(BookService service, BookView view){

        this.service = service;
        this.view = view;
    }

    public Reader getBorowTo(){

        return service.getBorrowTo();
    }
    
}
