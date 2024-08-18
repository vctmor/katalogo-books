package com.aranduteck.kataLogoBooks.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.dto.BookDto;
import com.aranduteck.kataLogoBooks.model.Reader;

public class BookViewTest {

    private BookView view;
    private Book modelMock;
    private BookDto bookDto;

    private String author = "Machado";
    private String title = "Capitu";
    private String catalogCode = "1";
    private Reader borrowTo = null;

    @BeforeEach
    public void setUp(){

         // Arrange
       modelMock = mock(Book.class);

        when(modelMock.getAuthor()).thenReturn(author);
        when(modelMock.getTitle()).thenReturn(title);
        when(modelMock.getCatalogCode()).thenReturn(catalogCode);
        when(modelMock.getBorrowTo()).thenReturn(borrowTo);

        bookDto = new BookDto(modelMock);
    }

     @Test
    public void ShowBookInformation_test(){

      BookView view = new BookView(bookDto);
    
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

    @Test
    public void toStringTest(){

         BookView view = new BookView(bookDto);

        final String TO_STRING_FORMAT = "\"Título: %s Autor: %s\"";

        String expected = String.format(
            TO_STRING_FORMAT , 
            modelMock.getTitle(), 
            modelMock.getAuthor());

        String actual = view.toString();

        assertEquals(expected, actual);
    }


}
