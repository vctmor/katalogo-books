package com.aranduteck.kataLogoBooks.view;

import com.aranduteck.kataLogoBooks.model.dto.BookDto;

public class BookView {

    private BookDto model;

     private static final String BOOK_INFO_FORMAT = """
            Título: %s;
            Autor: %s;
            Número de catálogo: %s;
            Já emprestado para: %s
            """;

    public BookView(BookDto bookDto) {
		
       this.model =  bookDto;
	}

	public String showBookInformation() {
       
//   if (borrowTo == null) {
//         borrowTo = "N/A"; // ou qualquer outra mensagem padrão
//     }

    String result =  String.format( 
                BOOK_INFO_FORMAT,
                model.title(),
                model.author(),
                model.catalogCode(),
                model.borrowTo());
System.out.println("Result: " + result);
        return result;
    }

      
}
