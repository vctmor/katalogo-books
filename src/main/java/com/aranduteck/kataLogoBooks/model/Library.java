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
   
    private HashSet<Reader> people;
    
    public Library(String libName){

        this.libName = libName;
        
        this.people = new HashSet<>();
    }

    public String getName(){

        return libName;
    }

    public HashSet<Reader> listOfPeople(){

        return people;
    }

}
