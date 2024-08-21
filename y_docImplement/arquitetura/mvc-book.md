Entendi! Vamos ajustar a sua classe `BookController` para seguir o padrão MVC sem usar Spring Boot. Vou incluir uma camada de serviço (`BookService`) e manter a interação com a view (`BookView`).

### Estrutura MVC
1. **Modelo (Model)**: Representa os dados e a lógica de negócios.
2. **Serviço (Service)**: Contém a lógica de negócios e interage com o modelo.
3. **Controlador (Controller)**: Recebe as requisições, chama os métodos do serviço e atualiza a view.
4. **Visualização (View)**: Exibe os dados para o usuário.

### Classe Entidade (Book)
```java
public class Book {
    private String catalogCode;
    private Reader borrowTo;

    // Getters e Setters
    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public Reader getBorrowTo() {
        return borrowTo;
    }

    public void setBorrowTo(Reader borrowTo) {
        this.borrowTo = borrowTo;
    }
}
```

### Classe Serviço (BookService)
```java
public class BookService {
    private Book book;

    public BookService(Book book) {
        this.book = book;
    }

    public Reader getBorrowTo() {
        return book.getBorrowTo();
    }

    public void assignToReader(Reader reader) {
        book.setBorrowTo(reader);
    }

    public void unassignFromReader() {
        book.setBorrowTo(null);
    }

    public void setCatalogCode(String code) {
        book.setCatalogCode(code);
    }

    public String getCatalogCode() {
        return book.getCatalogCode();
    }
}
```

### Classe Controladora (BookController)
```java
public class BookController {
    private BookService bookService;
    private BookView view;

    public BookController(BookService bookService, BookView view) {
        this.bookService = bookService;
        this.view = view;
    }

    public void displayBookDetails() {
        view.printBookDetails(bookService.getCatalogCode(), bookService.getBorrowTo());
    }

    public void assignToReader(Reader reader) {
        bookService.assignToReader(reader);
        view.printAssignmentSuccess(reader);
    }

    public void unassignFromReader() {
        bookService.unassignFromReader();
        view.printUnassignmentSuccess();
    }

    public void setCatalogCode(String code) {
        bookService.setCatalogCode(code);
        view.printCatalogCodeUpdateSuccess(code);
    }
}
```

### Classe de Visualização (BookView)
```java
public class BookView {
    public void printBookDetails(String catalogCode, Reader borrowTo) {
        System.out.println("Catalog Code: " + catalogCode);
        System.out.println("Borrowed To: " + (borrowTo != null ? borrowTo.getName() : "None"));
    }

    public void printAssignmentSuccess(Reader reader) {
        System.out.println("Book successfully assigned to " + reader.getName());
    }

    public void printUnassignmentSuccess() {
        System.out.println("Book successfully unassigned.");
    }

    public void printCatalogCodeUpdateSuccess(String code) {
        System.out.println("Catalog code successfully updated to " + code);
    }
}
```

### Uso do Controller
```java
public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        BookService bookService = new BookService(book);
        BookView view = new BookView();
        BookController controller = new BookController(bookService, view);

        // Exemplo de uso
        controller.setCatalogCode("12345");
        controller.displayBookDetails();

        Reader reader = new Reader("John Doe");
        controller.assignToReader(reader);
        controller.displayBookDetails();

        controller.unassignFromReader();
        controller.displayBookDetails();
    }
}
```

### Explicação
1. **Book**: A entidade que representa os dados do livro.
2. **BookService**: Contém a lógica de negócios e interage com a entidade `Book`.
3. **BookController**: Recebe as requisições, chama os métodos do serviço e atualiza a view.
4. **BookView**: Exibe os dados para o usuário.

Dessa forma, você mantém a separação de responsabilidades e segue o padrão MVC sem usar Spring Boot. Se precisar de mais detalhes ou tiver outras perguntas, estou aqui para ajudar!