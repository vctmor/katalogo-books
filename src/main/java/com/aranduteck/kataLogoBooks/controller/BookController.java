package com.aranduteck.kataLogoBooks.controller;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

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

    public void assignToReader(){

        service.assignToReader(getBorowTo());
    }

    public void setCatalogCode(String code) {
    
        service.setCatalogCode(code);
    
    }

    public String getCatalogCode() {
        
        return service.getCatalogCode();
    
    }

    public String  showBookInformation() {
        
       return view.showBookInformation();
    }

    // toString() já existe por padrão

    
}
