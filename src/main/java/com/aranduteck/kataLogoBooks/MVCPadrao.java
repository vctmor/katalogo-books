package com.aranduteck.kataLogoBooks;

import com.aranduteck.kataLogoBooks.controller.LivroController;
import com.aranduteck.kataLogoBooks.model.Livro;
import com.aranduteck.kataLogoBooks.view.BookView;
import com.aranduteck.kataLogoBooks.view.LivroView;

public class MVCPadrao {

    public static void main(String[] args) {
        
        Livro model = new Livro("Capitu", "Machado");

        LivroView view = new LivroView();

        LivroController controller = new LivroController(model, view);

        controller.atualizeView();

        controller.setAuthor("Aristófanes");
        controller.setTitle("As Nuvens");

        controller.atualizeView();

        BookView bv = new BookView();

        bv.showBookInformation("a", null, "b", "csa");
        
    }
    
}
