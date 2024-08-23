package com.aranduteck.kataLogoBooks.service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import com.aranduteck.kataLogoBooks.exceptions.BookNullException;
import com.aranduteck.kataLogoBooks.model.Book;

public class LibraryService {

    private int unicNumber;

     private TreeSet<Book> collection;


     public LibraryService(){

         this.collection = new TreeSet<>();
     }

    protected int count(){

        return unicNumber += 1; 
    }

    public String generatesUniqueCode() {

        final String PRE_FIX = "LIB";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
        String date = sdf.format(new Date());              

        return PRE_FIX + date + String.format("%04d",  count());    
    }


    public void addBook(Book book) throws BookNullException {

        if (book == null)
            throw new BookNullException("O objeto book não pode ser nulo.");
        
        book.getCatalogCode();
        collection.add(book);
    }
    
    public Set<Book> listOfBooksAvaliable(){

        return Collections.unmodifiableSet(collection);
    } 
   
    
}
