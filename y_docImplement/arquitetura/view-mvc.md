Claro! Aqui está um exemplo simples de um padrão de projeto MVC em Java para um sistema de gerenciamento de livros:

### 1. Model
A classe `Livro` representa o modelo, contendo os dados e a lógica de negócios.

```java
public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {

        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Getters e setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}
```

### 2. View
A classe `LivroView` é responsável por apresentar os dados ao usuário.

```java
public class LivroView {

    public void printDetalhesDoLivro(String titulo, String autor, int ano) {

        System.out.println("Livro: ");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano: " + ano);
    }
}
```

### 3. Controller
A classe `LivroController` gerencia a comunicação entre o modelo e a visão.

```java
public class LivroController {

    private Livro model;
    private LivroView view;

    public LivroController(Livro model, LivroView view) {
        
        this.model = model;
        this.view = view;
    }

    public void setTitulo(String titulo) {
        model.setTitulo(titulo);
    }

    public String getTitulo() {
        return model.getTitulo();
    }

    public void setAutor(String autor) {
        model.setAutor(autor);
    }

    public String getAutor() {
        return model.getAutor();
    }

    public void setAno(int ano) {
        model.setAno(ano);
    }

    public int getAno() {
        return model.getAno();
    }

    public void atualizarView() {
        view.printDetalhesDoLivro(model.getTitulo(), model.getAutor(), model.getAno());
    }
}
```

### 4. Main
A classe principal para testar o padrão MVC.

```java
public class MVCPadrao {
    public static void main(String[] args) {
        // Cria o modelo
        Livro model = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);

        // Cria a visão
        LivroView view = new LivroView();

        // Cria o controlador
        LivroController controller = new LivroController(model, view);

        // Atualiza a visão
        controller.atualizarView();

        // Atualiza o modelo e a visão
        controller.setTitulo("O Hobbit");
        controller.atualizarView();
    }
}
```

Neste exemplo, o `LivroController` atua como intermediário entre o `Livro` (Model) e o `LivroView` (View), garantindo que as mudanças no modelo sejam refletidas na visão e vice-versa. Isso ajuda a manter o código organizado e facilita a manutenção e a escalabilidade do sistema. Se precisar de mais detalhes ou tiver alguma dúvida, estou aqui para ajudar!

Fonte: conversa com o Copilot, 15/08/2024
(1) Padrão MVC (Model-View-Controller) Tutorial - DevMedia. https://www.devmedia.com.br/padrao-mvc-java-magazine/21995.
(2) Java SE: Aprendendo o padrão MVC - DevMedia. https://www.devmedia.com.br/java-se-aprendendo-o-padrao-mvc/29546.
(3) Estrutura de Pastas em um Projeto Java: Organização Eficiente com MVC. https://bing.com/search?q=exemplo+padr%c3%a3o+projeto+MVC+Java.
(4) Desvendando o MVC: Entenda o Padrão de Arquitetura. https://devporai.com.br/desvendando-o-mvc-entenda-o-padrao-de-arquitetura/.
(5) Estrutura de Pastas em um Projeto Java: Organização Eficiente com MVC. https://www.dio.me/articles/projeto-exemplo-em-java-usando-mvc.
(6) github.com. https://github.com/AsaphSouza/Segunda_chamada/tree/f4430539ed89a041af0645d0ece6e7f63ea56f11/src%2Fentidades%2FLivro.java.
(7) github.com. https://github.com/calebesz/poo-2020-01/tree/825e1dedb3e7778f04542190102943cfb784ef84/T29%2F04%2Fsrc%2Fpkg02%2FLivro.java.