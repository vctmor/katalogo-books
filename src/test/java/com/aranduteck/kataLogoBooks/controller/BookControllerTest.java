package com.aranduteck.kataLogoBooks.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;
import com.aranduteck.kataLogoBooks.model.dto.BookDto;
import com.aranduteck.kataLogoBooks.service.BookService;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookControllerTest {

    @Mock
    private BookController controller;

    private Book model;
   
    private BookService service;
    private BookView view;
    private BookDto dto;
    private Reader reader;

    private String author = "Machado";
    private String title = "Capitu";

    @BeforeEach
    public void setUp(){

        MockitoAnnotations.openMocks(this);
        
        // view = new BookView(dto);
        view = mock(BookView.class);
        // model = new Book(title, author);
        model = mock(Book.class);
        // service = new BookService(model);
        service = mock(BookService.class);

        // controller = new BookController(service, view);

        reader = mock(Reader.class);
 
    }

    @Test
    public void getBorowTest(){

        when(controller.getBorowTo()).thenReturn(reader);
        
        assertEquals(reader, controller.getBorowTo());
    }

    @Test
    public void assignToReaderTest(){

        when(controller.getBorowTo()).thenReturn(reader);
        
       controller.assignToReader();

        assertEquals(reader, controller.getBorowTo());

    }

      @Test
    public void setCatalogCodeTest(){

        String code = "123";

        doNothing().when(controller).setCatalogCode(code);
        when(controller.getCatalogCode()).thenReturn(code);
        
        controller.setCatalogCode(code);
        
        assertEquals(code, controller.getCatalogCode());

    }

     @Test
    public void getCatalogCodeTest(){

        String code = "123";

        when(controller.getCatalogCode()).thenReturn(code);

        
        assertEquals(code, controller.getCatalogCode());       
  
    }



    

}
