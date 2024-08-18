package com.aranduteck.kataLogoBooks.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aranduteck.kataLogoBooks.exceptions.BookNullException;

public class LibraryTest {

    private Library lib;
    private String libName;
    private int numberUnic;
    private TreeSet<BookDto> repositoryLBooks;
    private HashSet<Reader> people;

    private BookDto book1;
    private BookDto book2;


    @BeforeEach
    public void setUp(){

        // Arrange
        libName ="Olorum";
        lib = new Library(libName);

        book1 = new BookDto("Helena", "Machado");
        book2 = new BookDto("Medalhão", "Machado");
        repositoryLBooks = new TreeSet<>();
        repositoryLBooks.add(book1);
        repositoryLBooks.add(book2);
    }

    @Test
    public void construtor_test(){

        // AssertlistOfPeople
        assertEquals(libName, lib.getName());

        assertNotNull(lib.listOfBooksAvaliable());
        assertTrue(lib.listOfBooksAvaliable() instanceof Set<BookDto>);

        assertNotNull(lib.listOfPeople());
        assertTrue(lib.listOfPeople() instanceof HashSet);
    }

        @Test
    public void count_test(){

        // AssertlistOfPeople
        assertEquals(1, lib.count());
        assertEquals(2, lib.count());
    }

     @Test
    public void generatesUniqueCode_test(){

        // AssertlistOfPeople
        assertEquals("LIB202408140001", lib.generatesUniqueCode());
        assertEquals("LIB202408140002", lib.generatesUniqueCode());
    }

     @Test
    public void testAddBookThrowsExceptionWhenBookIsNull() {

        Exception exception = assertThrows(BookNullException.class,
        () -> { 
            lib.addBook(null);

        });

        String expectedMessage = "O objeto book não pode ser nulo.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

     @Test
    public void testListOfBooksAvaliable() {
        Set<BookDto> books = lib.listOfBooksAvaliable();
        
        // Verifica se o conjunto retornado é imutável
        assertThrows(UnsupportedOperationException.class, () -> books.add(new BookDto("Medalhão", "Machado")));
        
        // Verifica se o conjunto contém os livros esperados
        // assertTrue(books.containsAll(repositoryLBooks));
    }

     @Test
    public void addBook_test() throws BookNullException{

        String code1 = lib.generatesUniqueCode();
        book1.setCatalogCode(code1);
        lib.addBook(book1);

        //assertTrue(lib.listOfBooksAvaliable().contains(book1));

        // AssertlistOfPeople
        assertEquals(1,lib.listOfBooksAvaliable().size() );
        assertEquals("LIB202408140001", book1.getCatalogCode());
    }
}
