package com.aranduteck.kataLogoBooks.model;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private Reader borrowTo;
    private String catalogCode = "";

    public Book(String title, String author){

        this.title = title;
        this.author = author;
        this.borrowTo = null;
    }

    public void setCatalogCode(String code) {

        this.catalogCode = code;
    }

    public String getCatalogCode(){

        return catalogCode;
    }

    @Override
    public int hashCode(){

        return catalogCode.hashCode();
    }

    @Override
    public int compareTo(Book book) {

        if (this == book) return 1;

        if (book == null || getClass() != book.getClass()) return 0;
       
        return catalogCode.equals(book.catalogCode)? 1:0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;    
    }

    public void assignBookToPeople(Reader people) {
        
        this.borrowTo = people;    
    }

    public Reader getBorrowTo() {

        return borrowTo;
    }

    public void unassignPeopleFromBook() {
     
        this.borrowTo = null;    
    }

    public String showBookInformation() {
       
        return  String.format("""
                Título: %s;
                Autor: %s;
                Número de catálogo: %s;
                Já emprestado para: %s
                """,
                getTitle(),
                getAuthor(),
                getCatalogCode(),
                getBorrowTo());
    }

    @Override
    public String toString(){

        return "\"Título: " 
        + getTitle() 
        + " Autor: " 
        + getAuthor() + "\"";
    }

}
