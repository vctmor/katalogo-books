package com.aranduteck.kataLogoBooks.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.controller.BookController;
import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.view.BookView;

public class BookViewTest {

    private BookView view;
    private Book modelMock;
    private BookController controller;

    private String author = "Machado";
    private String title = "Capitu";

    @BeforeEach
    public void setUp(){

         // Arrange
       modelMock = mock(Book.class);

        when(modelMock.getAuthor()).thenReturn(author);
        when(modelMock.getTitle()).thenReturn(title);
        when(modelMock.getCatalogCode()).thenReturn("1");
        when(modelMock.getBorrowTo()).thenReturn(null);

    }

    @Test
    public void BookViewTest(){

        // Act
        BookView view = new BookView(modelMock);

        // Assert
        
        assertEquals()
    }

     @Test
    public void ShowBookInformation_test(){

        // Por que com mock o esperado fica null?
    //   view = mock(BookView.class);

       view = new BookView(modelMock);
    
        final String BOOK_INFO_FORMAT = """
            Título: %s;
            Autor: %s;
            Número de catálogo: %s;
            Já emprestado para: %s
            """;
        String information = String.format(
                BOOK_INFO_FORMAT,
                modelMock.getTitle(),
                modelMock.getAuthor(),
                modelMock.getCatalogCode(),
                modelMock.getBorrowTo()
                );

        String expectedInfo = view.showBookInformation();
        
        assertEquals(expectedInfo,information);
        
    }


}
