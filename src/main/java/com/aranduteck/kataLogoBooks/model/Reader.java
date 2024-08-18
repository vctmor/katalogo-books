package com.aranduteck.kataLogoBooks.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

import com.aranduteck.kataLogoBooks.exceptions.BookNullException;

import com.aranduteck.kataLogoBooks.exceptions.NameNullException;

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

public class Reader implements Comparable<Reader> {

    private String name;
    private LinkedList<BookDto> bookList;
    
    public Reader(String name ) throws NameNullException{

        setName(name);
        bookList = new LinkedList<BookDto>();
    }

    public void setName(String name) throws NameNullException{

        if ( name == null || name.isEmpty())  
            throw new NameNullException("O objeto name não pode ser nulo nem vazio.");         
            
       this.name = name;
    }

    public String getName(){

        return name;
    }    

    public void assignBook(BookDto book) throws BookNullException{

        if ( book == null  )
            throw new BookNullException("O objeto book não pode ser nulo.");         
        bookList.add(book);
    }

  public void unassignBook(BookDto book) throws BookNullException {

        if ( book == null  )
            throw new BookNullException("O objeto book não pode ser nulo.");         
            
        if (getBooks().size() > 0)
            bookList.remove(book);
    }

    public List<BookDto> getBooks(){

       return Collections.unmodifiableList(bookList);
    }

    public String displaysHistoryOfBookLoans() {

        return  String.format("""
                Pessoa Leitora: %s;
                Quantidade livros emprestados: %d;
                Lista dos livros: %s;

                """, 
                getName(),
                getBooks().size(),
                getBooks().toString());
    }

    @Override
    public String toString(){

        return String.format("""
                Nome: %s;
                Quantos livros emprestados: %d;
                """,
                getName(),
                getBooks().size());
    }
    @Override
    public int compareTo(Reader obj) {

        // se People implements Comparable<People>, então:
        // this.nome.compareTo(outraPessoa.nome);

        if (obj == null)
            throw new NullPointerException("O objeto não pode ser nulo.");
        
        Reader people = (Reader) obj;
        String name = people.getName();
        return this.name.compareTo(name);        
    }

    @Override
    public boolean equals(Object obj){

        return this.compareTo((Reader)obj) == 0;
    }

    @Override
    public int hashCode(){

        return name.hashCode();
    }
    
}
