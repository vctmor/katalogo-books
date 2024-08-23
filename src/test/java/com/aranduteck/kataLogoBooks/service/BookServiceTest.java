package com.aranduteck.kataLogoBooks.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.service.BookService;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookServiceTest {

    // private BookDto bdto;
    private Book model;
    private BookView view;
    private BookService controller;
    private Reader readerMock;

    private String author = "Machado";
    private String title = "Capitu";

    @BeforeEach
    public void setUp(){
 
        model = new Book(title, author);
        
        controller = new BookService(model);
    }


    @Test
    public void setBorowTest(){

        readerMock = mock(Reader.class);
        controller.setBorrowTo(readerMock);
        
       assertEquals(readerMock, controller.getBorrowTo());
    }


    @Test
    public void getBorowTest(){

       assertEquals(null, controller.getBorrowTo());
    }

    @Test
    public void assignToReaderTest(){

        readerMock = mock(Reader.class);
        
        controller.assignToReader(readerMock);

        assertNotNull(controller.getBorrowTo());
    }

    @Test
    public void unassignFromReaderTest(){

        readerMock = mock(Reader.class);
        
        controller.assignToReader(readerMock);

        controller.unassignFromReader();

        assertNull(controller.getBorrowTo());        
    }

    @Test
    public void set_getCatalogCodeTest(){

        String code = "123";

        controller.setCatalogCode(code);

        String get = controller.getCatalogCode();

        assertEquals(code, get);
    }

    //TODO: traçar próximos passos


}
