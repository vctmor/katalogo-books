package com.aranduteck.kataLogoBooks.controller;

import com.aranduteck.kataLogoBooks.model.Livro;
import com.aranduteck.kataLogoBooks.view.LivroView;

public class LivroController {

    // Gerencia a comunicação entre o modelo e a visão

    private Livro model;
    private LivroView view;

    public LivroController(Livro model, LivroView view){

        this.model = model;
        this.view = view;
    }
    public void setTitle(String title){

        model.setTitulo(title);
    }

    public String getTitle(){

        return model.getTitulo();
    }

    public void setAuthor(String author){

        model.setAutor(author);
    }

    public String getAuthor(){

        return model.getAutor();
    }

    public void atualizeView(){

        view.printDetalhesDoLivro(getTitle(), getAuthor());
    }


}
