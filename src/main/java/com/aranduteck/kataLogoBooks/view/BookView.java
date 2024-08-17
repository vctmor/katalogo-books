package com.aranduteck.kataLogoBooks.view;

import com.aranduteck.kataLogoBooks.model.Book;
import com.aranduteck.kataLogoBooks.model.Reader;

public class BookView {

     private static final String BOOK_INFO_FORMAT = """
            Título: %s;
            Autor: %s;
            Número de catálogo: %s;
            Já emprestado para: %s
            """;

    public BookView(Book modelMock) {
		//TODO Auto-generated constructor stub
	}

	public String showBookInformation() {
       
//   if (borrowTo == null) {
//         borrowTo = "N/A"; // ou qualquer outra mensagem padrão
//     }

    String result =  String.format( 
                BOOK_INFO_FORMAT,
                title,
                author,
                catalogCode,
                borrowTo);
System.out.println("Result: " + result);
        return result;
    }

      
}
