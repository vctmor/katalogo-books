package com.aranduteck.kataLogoBooks.model.dto;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;

public record BookDto (
    String title,
    String author,
    String catalogCode,
    Reader borrowTo
) {

    public BookDto(Book book) {
      
        this(book.getTitle(), 
        book.getAuthor(), 
        book.getCatalogCode(), 
        book.getBorrowTo());
    }
    
}
