package com.aranduteck.kataLogoBooks.service;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;

public class BookService {

    private Book model;
   

    public BookService(Book model){

        this.model = model;
          
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
