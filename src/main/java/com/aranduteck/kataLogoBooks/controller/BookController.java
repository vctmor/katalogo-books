package com.aranduteck.kataLogoBooks.controller;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookController {

    private Book model;
    private BookView view;

    public BookController(Book model, BookView view){

        this.model = model;
        this.view = view;   
    }

      public Reader getBorrowTo(){

        return model.getBorrowTo();
    }

    public void assignToReader(Reader reader) {

        model.setBorrowTo(reader);
    }
	public void unassignFromReader() {
	
    model.setBorrowTo(null);    
        
    }    

    public void setCatalogCode(String code){

        model.setCatalogCode(code);
    }

    public String getCatalogCode(){

        return model.getCatalogCode();
    }

    public void setBorrowTo(Reader reader) {
        
        model.setBorrowTo(reader);;
    }

}
