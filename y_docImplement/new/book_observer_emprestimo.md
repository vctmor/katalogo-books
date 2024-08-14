Para implementar o padrão Observer em Java para notificar sobre empréstimos e devoluções de livros, você pode seguir os seguintes passos:

### 1. Definir a Interface Observer

Primeiro, crie uma interface `Observer` que será implementada por todas as classes que precisam ser notificadas sobre mudanças no estado do empréstimo.

```java
package ita.sab;

public interface Observer {
    void update(Book book, String message);
}
```

### 2. Definir a Classe Subject

Em seguida, crie uma classe `Subject` que mantém uma lista de observadores e notifica-os sobre mudanças.

```java
package ita.sab;

import java.util.ArrayList;
import java.util.List;

public class LoanManager {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book, String message) {
        for (Observer observer : observers) {
            observer.update(book, message);
        }
    }
}
```

### 3. Modificar a Classe Loan

Modifique a classe `Loan` para notificar os observadores quando um livro for emprestado ou devolvido.

```java
package ita.sab;

public class Loan {
    private Book book;
    private People borrower;
    private LoanManager loanManager;

    public Loan(Book book, People borrower, LoanManager loanManager) {
        this.book = book;
        this.borrower = borrower;
        this.loanManager = loanManager;
        loanManager.notifyObservers(book, "Book borrowed by " + borrower.getName());
    }

    public Book getBook() {
        return book;
    }

    public People getBorrower() {
        return borrower;
    }

    public void returnBook() {
        loanManager.notifyObservers(book, "Book returned by " + borrower.getName());
        this.borrower = null;
    }

    @Override
    public String toString() {
        return String.format("Livro: %s, Emprestado para: %s", book, borrower);
    }
}
```

### 4. Implementar a Classe Observer

Crie uma classe que implemente a interface `Observer` e defina o comportamento quando uma notificação for recebida.

```java
package ita.sab;

public class LibrarySystem implements Observer {
    @Override
    public void update(Book book, String message) {
        System.out.println("Notification: " + message + " - " + book);
    }
}
```

### 5. Testar a Implementação

Finalmente, teste a implementação criando instâncias das classes e verificando se as notificações estão funcionando corretamente.

```java
package ita.sab;

public class Main {
    public static void main(String[] args) {
        LoanManager loanManager = new LoanManager();
        LibrarySystem librarySystem = new LibrarySystem();
        loanManager.addObserver(librarySystem);

        Book book = new Book("Effective Java", "Joshua Bloch");
        People person = new People("John Doe");

        Loan loan = new Loan(book, person, loanManager);
        loan.returnBook();
    }
}
```

### Conclusão

Com essa implementação, sempre que um livro for emprestado ou devolvido, todos os observadores registrados serão notificados. Isso segue o padrão Observer, permitindo que diferentes partes do sistema reajam a mudanças no estado do empréstimo de forma desacoplada¹². Se precisar de mais alguma coisa, estou aqui para ajudar!

¹: [Baeldung - The Observer Pattern in Java](https://www.baeldung.com/java-observer-pattern)
²: [DigitalOcean - Observer Design Pattern in Java](https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java)

Fonte: conversa com o Copilot, 12/08/2024
(1) The Observer Pattern in Java | Baeldung. https://www.baeldung.com/java-observer-pattern.
(2) Observer Design Pattern in Java | DigitalOcean. https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java.
(3) Observer Method Design Pattern in Java - GeeksforGeeks. https://www.geeksforgeeks.org/observer-method-design-pattern-in-java/.
(4) Observer Pattern - The Java Design Patterns Manual. https://javadesignpatterns.com/catalog/behavioral-patterns/observer-pattern/.
(5) The Observer Design Pattern: Implementing Event Handling in Java. https://www.momentslog.com/development/design-pattern/the-observer-design-pattern-implementing-event-handling-in-java.