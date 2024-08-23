package com.aranduteck.kataLogoBooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aranduteck.kataLogoBooks.exceptions.BookNullException;
import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Library;


public class LibraryServiceTest {

        private int unicNumber;

        @Mock
        private LibraryService service;
        @Mock
        private Book book;

        private TreeSet<Book> collection;

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.openMocks(this);

        service = new LibraryService();
        book = new Book("Dom Casmurro", "Machadão");
        //book = mock(Book.class);
       collection = new TreeSet<>();
    }
     
     @Test 
    public void countTest(){
    
        int unicNumber = service.count();

       assertEquals(1, unicNumber);              
    }
    
    @Test 
    public void generatesUniqueCodeTest(){

        final String PRE_FIX = "LIB";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
        String date = sdf.format(new Date());       
        
        String expected = PRE_FIX + date + String.format("%04d", 1);

        assertEquals(expected, service.generatesUniqueCode());
    }


    @Test
    public void addBookTest() throws BookNullException{
  
        service.addBook(book);

        assertEquals(1, service.listOfBooksAvaliable().size());
    }

    @Test
    public void listOfBooksAvaliableTest() throws BookNullException{

       

       assertTrue(service.listOfBooksAvaliable().isEmpty());
       service.addBook(book);
       assertFalse(service.listOfBooksAvaliable().isEmpty());


    }


}
