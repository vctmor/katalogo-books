package com.aranduteck.kataLogoBooks.model;

import com.aranduteck.kataLogoBooks.exceptions.NameNullException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//@ExtendWith(StringParameterResolver.class)
public class BookTest {

    private BookDto book1;    
    private BookDto book2;    

    private String title;
    private String author;

    private Reader reader;
    private String name = "Heloísa";

    private Library lib;
    private String code1;

    @BeforeEach
    public void createBook() throws NameNullException{

        this.title = "Helena";
        this.author = "Machado de Assis";

        book1 = new BookDto(title, author);
        book2 = new BookDto("Dom Casmurro", author);

        reader = new Reader(name);

        lib = new Library("Dedalus");

        code1 = lib.generatesUniqueCode();
    }
    
    @Test
    public void testCreateBook_pt1_book(){

        assertEquals(book1, book1);       
    }

     @Test
    public void testCreateBook_pt2_author_title(){
       
        assertEquals(book1.getAuthor(), author);
        assertEquals(book1.getTitle(), title);       
    }

      @Test
    public void testCreateBook_pt3_borrowToNull(){

        assertEquals(null, book1.getBorrowTo());
    }

    @Test//assign
    public void testAssignReader(){
//assign
        book1.assignToReader(reader);

        assertEquals(book1.getBorrowTo(), reader);        
    }

     @Test
    public void testUnassignFromReader(){

        book1.unassignFromReader();

        assertEquals(null, book1.getBorrowTo());        
    }

   @Test
    public void getCatalogNumber_test(){

         assertEquals("", book1.getCatalogCode());     
    }

    @Test
    public void setCatalogNumber_test(){

    book1.setCatalogCode(code1);

    assertEquals("LIB202408140001", book1.getCatalogCode());
    }

    @Test
     public void hashCode_test(){

        BookDto book3 = new BookDto("Helena", author);
        book3.setCatalogCode(lib.generatesUniqueCode());

        book1.setCatalogCode(code1);
        assertEquals("LIB202408140001", book1.getCatalogCode());

        assertEquals(book1.hashCode(), book1.hashCode());
        assertNotEquals(book1.hashCode(), book3.hashCode());
        assertNotEquals(book1.hashCode(), book2.hashCode());        
    }

    @Test
    public void compareTo_compareCurrentBookWithAnotherBookByCatalogCode_test(){

        book1.setCatalogCode(lib.generatesUniqueCode());

        BookDto book3 = new BookDto("Helena", author);
        book3.setCatalogCode(lib.generatesUniqueCode());

        assertEquals(1, book1.compareTo(book1));
        assertEquals(0, book3.compareTo(book1));
        assertEquals(0, book2.compareTo(book1));
    }

      @Test
    public void comparingByCatalogCode_test(){

        String code2 = lib.generatesUniqueCode();

        book1.setCatalogCode(code1);
        book2.setCatalogCode(code2);

        assertNotEquals(book1.getCatalogCode(), book2.getCatalogCode());
    }
   
    @Test
    public void ShowBookInformation_test(){

        final String BOOK_INFO_FORMAT = """
            Título: %s;
            Autor: %s;
            Número de catálogo: %s;
            Já emprestado para: %s
            """;

        String expectedInfo = book1.showBookInformation();
        
        String information = String.format(
                BOOK_INFO_FORMAT,
                book1.getTitle(),
                book1.getAuthor(),
                book1.getCatalogCode(),
                book1.getBorrowTo());
        
        assertEquals(expectedInfo,information);
        
    }

    @Test
    public void toString_test(){

        String real = book1.toString();

        final String TO_STRING_FORMAT = "\"Título: %s Autor: %s\"";

        String expected = String.format(
            TO_STRING_FORMAT,
            book1.getTitle(),
            book2.getAuthor());

        assertEquals(expected, real);
    }

}
