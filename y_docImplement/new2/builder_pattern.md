Claro! Aqui está um exemplo completo do padrão Builder aplicado a uma classe `Book`. Esse padrão é útil para criar objetos complexos de forma mais legível e flexível.

### Classe `Book` com Builder Pattern

```java
package ita.sab;

public class Book {
    private final String title;
    private final String author;
    private final String catalogCode;
    private final People borrowTo;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.catalogCode = builder.catalogCode;
        this.borrowTo = builder.borrowTo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public People getBorrowTo() {
        return borrowTo;
    }

    @Override
    public String toString() {
        return String.format("Título: %s, Autor: %s, Número de catálogo: %s, Emprestado para: %s",
                title, author, catalogCode, borrowTo != null ? borrowTo.getName() : "N/A");
    }

    public static class Builder {
        private String title;
        private String author;
        private String catalogCode = "";
        private People borrowTo;

        public Builder(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public Builder catalogCode(String catalogCode) {
            this.catalogCode = catalogCode;
            return this;
        }

        public Builder borrowTo(People borrowTo) {
            this.borrowTo = borrowTo;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
```

### Uso do Builder Pattern

Aqui está um exemplo de como usar o Builder Pattern para criar uma instância de `Book`:

```java
package ita.sab;

public class Main {
    public static void main(String[] args) {
        People person = new People("John Doe");

        Book book = new Book.Builder("Effective Java", "Joshua Bloch")
                .catalogCode("12345")
                .borrowTo(person)
                .build();

        System.out.println(book);
    }
}
```

### Vantagens do Builder Pattern

1. **Flexibilidade**: Permite criar objetos com diferentes configurações sem precisar de múltiplos construtores ou setters.
2. **Imutabilidade**: Facilita a criação de objetos imutáveis, o que melhora a segurança em ambientes multi-thread.
3. **Legibilidade**: O código se torna mais legível e fácil de entender, especialmente quando há muitos parâmetros.

Esse exemplo mostra como o Builder Pattern pode ser usado para criar objetos complexos de forma clara e eficiente¹². Se precisar de mais alguma coisa, estou aqui para ajudar!

¹: [Baeldung - Implement the Builder Pattern in Java 8](https://www.baeldung.com/java-builder-pattern)
²: [HowToDoInJava - Java Builder Pattern: Build Complex Objects Efficiently](https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/)

Fonte: conversa com o Copilot, 12/08/2024
(1) Implement the Builder Pattern in Java 8 | Baeldung. https://www.baeldung.com/java-builder-pattern.
(2) Java Builder Pattern: Build Complex Objects Efficiently - HowToDoInJava. https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/.
(3) Builder Method Design Pattern in Java - GeeksforGeeks. https://www.geeksforgeeks.org/builder-pattern-in-java/.