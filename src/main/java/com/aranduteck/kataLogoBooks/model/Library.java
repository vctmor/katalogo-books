package com.aranduteck.kataLogoBooks.model;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.aranduteck.kataLogoBooks.exceptions.BookNullException;


public class Library {

    private String libName;
    private int unicNumber;
    private TreeSet<BookDto> collection;
    private HashSet<Reader> people;
    
    public Library(String libName){

        this.libName = libName;
        this.collection = new TreeSet<>();
        this.people = new HashSet<>();
    }

    public String getName(){

        return libName;
    }

    public Set<BookDto> listOfBooksAvaliable(){

        return Collections.unmodifiableSet(collection);
    } 

    public HashSet<Reader> listOfPeople(){

        return people;
    }

    public String generatesUniqueCode() {

        final String PRE_FIX = "LIB";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
        String date = sdf.format(new Date());              

        return PRE_FIX + date + String.format("%04d",  count());    
    }

    protected int count(){

        return unicNumber += 1; 
    }

    public void addBook(BookDto book) throws BookNullException {

        if (book == null)
            throw new BookNullException("O objeto book não pode ser nulo.");
        
        book.getCatalogCode();
        collection.add(book);
    }
    
}
