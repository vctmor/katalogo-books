package com.aranduteck.kataLogoBooks.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ita.sab.exceptions.BookNullException;
import ita.sab.exceptions.NameNullException;

public class ReaderTest {

    private Reader reader1;
    private Reader reader2;
    private String name;
    private LinkedList<BookDto> bookList;
    private BookDto book1; 
    private BookDto book2; 

    @BeforeEach
    public void setUp() throws NameNullException{

        this.name = "Heloísa";
                
        reader1 = new Reader(name);
        reader2 = new Reader("Jurandir");

        book1 = new BookDto("República", "Platão");
        book2 = new BookDto("Ética", "Aristóteles");
    }

    @Test
    public void constructor_test(){

        String name = reader1.getName();

         int size = reader1.getBooks().size();

        assertEquals("Heloísa", name);
         assertEquals(0, size);        

    }

    @Test
    public void getName_test(){

        assertEquals("Heloísa", reader1.getName());
    }

    @Test
    public void setName_test() throws NameNullException{

        reader1.setName("Heloísa");
        String name = reader1.getName();

        assertEquals(name, "Heloísa" );       
    }

     @Test
    public void testSetNameThrowsExceptionWhenNameIsNull(){

        Exception exception = assertThrows(NameNullException.class,
        () -> {reader1.setName(null);

        });

        String expectedMessage = "O objeto name não pode ser nulo nem vazio.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
  
    @Test
    public void assignBook_test() throws BookNullException{

        reader1.assignBook(book1);

        int size = reader1.getBooks().size();

        //assertEquals("Heloísa", name);
        assertEquals(1, size);         
    }

     @Test
    public void testAssignBookThrowsExceptionWhenBookIsNull() {
        Exception exception = assertThrows(BookNullException.class,
        () -> {reader1.assignBook(null);
            
        });

        String expectedMessage = "O objeto book não pode ser nulo.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        
    }

     @Test
    public void unassignBook_test() throws BookNullException{

        reader1.assignBook(book1);
        reader1.unassignBook(book1);

        int size = reader1.getBooks().size();
        //assertEquals("Heloísa", name);
        assertEquals(0, size);         
    }

     @Test
    public void testUnassignBookThrowsExceptionWhenBookIsNull() {

        Exception exception = assertThrows(BookNullException.class,
        () -> {reader1.assignBook(null);
            
        });

        String expectedMessage = "O objeto book não pode ser nulo.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        
    }

    // TODO: aprender a implementar a classe abaixo
// class ImmutableBookList {
//     private final List<Book> bookList;

//     public ImmutableBookList(List<Book> bookList) {
//         this.bookList = Collections.unmodifiableList(new LinkedList<>(bookList));
//     }

//     public List<Book> getBooks() {
//         return bookList;
//     }
// }

      @Test
    public void getBooks_test() throws BookNullException{

        reader1.assignBook(book1);
        reader1.assignBook(book2);

         List<BookDto> bookList = reader1.getBooks();

        assertNotNull(bookList);
        assertEquals(2, bookList.size());
        assertEquals("República", bookList.get(0).getTitle());
        assertEquals("Ética", bookList.get(1).getTitle());
        
    }

//       @Test
//     public void getBooksImutable_test(){

//           reader1.assignBook(book1);
//         reader1.assignBook(book2);

//         bookList = reader1.getBooks();

//         assertThrows(UnsupportedOperationException.class,
//         () -> bookList.add( book1) );
// }

    @Test
    public void displaysHistoryOfBookLoans_Test() throws BookNullException {

        BookDto book2 = new BookDto("República", "Platão");
        BookDto book3= new BookDto("República", "Platão");

        reader1.assignBook(book1);
        reader1.assignBook(book2);
        reader1.assignBook(book3);

        String expected = reader1.displaysHistoryOfBookLoans();

        String assumed = String.format("""
                Pessoa Leitora: %s;
                Quantidade livros emprestados: %d;
                Lista dos livros: %s;

                """, 
                reader1.getName(),
                reader1.getBooks().size(),
                reader1.getBooks());

        assertEquals(expected, assumed);
    } 

    @Test    
    public void toString_test(){

        String expected = reader1.toString();
        String assumed = String.format("""
                Nome: %s;
                Quantos livros emprestados: %d;
                """,
                reader1.getName(),
                reader1.getBooks().size());

        assertEquals(expected, assumed);
    }

    @Test
    public void compareTo_test(){

        int compare1 = reader1.compareTo(reader1);       
        assertEquals(0, compare1);

        int compare2 = reader1.compareTo(reader2);       
        assertNotEquals(0, compare2);
    }

         @Test
    public void testCompareToThrowsExceptionWhenObjIsNull() { 

        Exception exception = assertThrows(NullPointerException.class,
         () -> { reader1.compareTo(null);
        
        });

        String expectedMessage = "O objeto não pode ser nulo.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void equals_test(){

        boolean compare1 = reader1.equals(reader1);       
        assertTrue(compare1);

       boolean compare2 = reader1.equals(reader1);       
        assertTrue(compare2);

    }

           @Test
    public void testCompareToThrowsExceptionWhenObjIsNull_2() { 

        Exception exception = assertThrows(NullPointerException.class, 
        () -> { reader1.equals(null);
        
        });

        String expectedMessage = "O objeto não pode ser nulo.";

           String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test 
    public void hasCode_test(){

        assertEquals("Heloísa".hashCode(), reader1.hashCode());

    }


}
