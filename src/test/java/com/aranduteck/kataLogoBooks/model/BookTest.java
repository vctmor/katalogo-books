package com.aranduteck.kataLogoBooks.model;

import com.aranduteck.kataLogoBooks.exceptions.NameNullException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//@ExtendWith(StringParameterResolver.class)
public class BookTest {

    private Book book1;    
    private Book book2;    

    private String title;
    private String author;

    private Reader people;
    private String name = "Heloísa";

    private Library lib;
    private String code1;

    @BeforeEach
    public void createBook() throws NameNullException{

        this.title = "Helena";
        this.author = "Machado de Assis";

        book1 = new Book(title, author);
        book2 = new Book("Dom Casmurro", author);

        people = new Reader(name);

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
    public void testAssignPeopleToBook(){
//assign
        book1.assignBookToPeople(people);

        assertEquals(book1.getBorrowTo(), people);        
    }

     @Test
    public void testUnassignPeopleFromBook(){

        book1.unassignPeopleFromBook();

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

        Book book3 = new Book("Helena", author);
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

        Book book3 = new Book("Helena", author);
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

        String expectedInfo = book1.showBookInformation();
        //String catalogNumber = book.generateCatalogNumber();
        String information = String.format("""
                Título: %s;
                Autor: %s;
                Número de catálogo: %s;
                Já emprestado para: %s
                """,
                book1.getTitle(),
                book1.getAuthor(),
                book1.getCatalogCode(),
                book1.getBorrowTo());
        
        assertEquals(expectedInfo,information);
        
    }

    @Test
    public void toString_test(){

        String real = book1.toString();

        String expected = "\"Título: " + "Helena" + " Autor: " + "Machado de Assis" + "\"";

        assertEquals(expected, real);
    }

}
