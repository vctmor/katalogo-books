Para implementar a classe `Usuario`, você precisará considerar os seguintes requisitos e informações:

### Requisitos Funcionais

1. **Criar People**:
   - Método: `People(String nome)`
   - Descrição: Construtor que inicializa o People com um nome e uma lista de livros vazia.

2. **Anexar Livro ao People**:
   - Método: `anexaLivroAoPeople(Livro livro)`
   - Descrição: Adiciona um livro à lista de livros do People, se o livro não for nulo.

3. **Desanexar Livro do People**:
   - Método: `desanexaLivroDoPeople(Livro livro)`
   - Descrição: Remove um livro da lista de livros do People.

4. **Exibir Informações do People**:
   - Método: `exibe()`
   - Descrição: Exibe o nome do People e a lista de livros emprestados.

5. **Exibir Livros do People**:
   - Método: `exibeLivrosPeople()`
   - Descrição: Exibe a lista de livros emprestados pelo People.

6. **Comparar Peoples**:
   - Método: `compareTo(Object obj)`
   - Descrição: Compara o People atual com outro People pelo nome.

7. **Verificar Igualdade de Peoples**:
   - Método: `equals(Object obj)`
   - Descrição: Verifica se dois Peoples são iguais com base no nome.

8. **Gerar Código Hash**:
   - Método: `hashCode()`
   - Descrição: Gera um código hash para o People com base no nome.

9. **Converter People para String**:
   - Método: `toString()`
   - Descrição: Retorna uma representação em string do People.

10. **Obter Nome do People**:
    - Método: `getNome()`
    - Descrição: Retorna o nome do People.

11. **Definir Nome do People**:
    - Método: `setNome(String _nome)`
    - Descrição: Define o nome do People.

12. **Obter Livros do People**:
    - Método: `getLivros()`
    - Descrição: Retorna a lista de livros do People.

### Requisitos Não Funcionais

1. **Estrutura de Dados**:
   - Livros são armazenados em uma `LinkedList<Livro>`, permitindo fácil adição e remoção de livros.

2. **Implementação da Interface `Comparable`**:
   - A classe `People` implementa a interface `Comparable<Object>`, permitindo a comparação de Peoples com base no nome.

### Informações Adicionais

- **Construtor**:
  - `People(String nome)`: Inicializa o People com um nome e uma lista de livros vazia.

- **Métodos Públicos**:
  - `assignBookToPeople(Livro livro)`: Adiciona um livro à lista de livros do People.
  - `unassignBookToPeople(Livro livro)`: Remove um livro da lista de livros do People.
  - `displaysHistoryOfBookLoans()`: Exibe o nome do People e a lista de livros emprestados.
  - `compareTo(Object obj)`: Compara o People atual com outro People pelo nome.
  - `equals(Object obj)`: Verifica se dois Peoples são iguais com base no nome.
  - `hashCode()`: Gera um código hash para o People com base no nome.
  - `toString()`: Retorna uma representação em string do People.
  - `getName()`: Retorna o nome do People.
  - `setName(String _nome)`: Define o nome do People.
  - `getBooks()`: Retorna a lista de livros do People.

- **Métodos Privados**:
  - `exibeLivrosPeople()`: Exibe a lista de livros emprestados pelo People.

### Exemplo de Implementação

Aqui está um exemplo de como você pode começar a implementar a classe `People`:

```java
import java.util.LinkedList;
import java.util.Iterator;

public class People implements Comparable<Object> {
    private String _nome;
    private LinkedList<Livro> _livros;

    public People(String nome) {
        setNome(nome);
        _livros = new LinkedList<Livro>();
    }

    public void anexaLivroAoPeople(Livro livro) {
        if (livro != null)
            _livros.add(livro);
    }

    public void desanexaLivroDoPeople(Livro livro) {
        _livros.remove(livro);
    }

    public void exibe() {
        System.out.println("\t\t" + "Nome: " + "\t\t" + getNome());
        this.exibeLivrosPeople();
    }

    private void exibeLivrosPeople() {
        System.out.println("\t\t" + "\\//Livros emprestados:");
        if (_livros.size() != 0) {
            Iterator<Livro> iter = _livros.iterator();
            while (iter.hasNext()) {
                Livro livro = iter.next();
                System.out.println("\t\t\t" + livro.getNrCatalogo() + " " + livro);
            }
        } else {
            System.out.println("\t\t" + "---> Nenhum livro emprestado");
        }
        System.out.println("\t\t" + "\\///\\///\\///");
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        return this.compareTo(obj) == 0;
    }

    @Override
    public int compareTo(Object obj) {
        People People = (People) obj;
        String nome = People.getNome();
        return _nome.compareTo(nome);
    }

    @Override
    public int hashCode() {
        return _nome.hashCode();
    }

    @Override
    public String toString() {
        return "\"" + getNome() + "\"";
    }

    public String getNome() {
        return _nome;
    }

    protected void setNome(String _nome) {
        this._nome = _nome;
    }

    public LinkedList<Livro> getLivros() {
        return _livros;
    }
}
```

Espero que isso ajude você a entender melhor como implementar a classe `People`! Se precisar de mais detalhes ou tiver outras dúvidas, estou aqui para ajudar.

Fonte: conversa com o Copilot, 27/07/2024
(1) java - What does "implements" do on a class? - Stack Overflow. https://stackoverflow.com/questions/4558111/what-does-implements-do-on-a-class.
(2) extends class and implements interface in java - Stack Overflow. https://stackoverflow.com/questions/14021827/extends-class-and-implements-interface-in-java.
(3) Java Class and Objects (With Example) - Programiz. https://www.programiz.com/java-programming/class-objects.
(4) Java Interface Example, Explanation, and Implementation. https://blog.udemy.com/java-interface-example/.
(5) How to create Immutable class in Java? - GeeksforGeeks. https://www.geeksforgeeks.org/create-immutable-class-java/.
(6) undefined. http://www.java2s.com/Code/Php/Class/extendsandimplement.htm.
(7) github.com. https://github.com/KevinDaSilvaS/TDD-ITA/tree/c13af0cb71ca2fb5b0804b866be630b9b45f4c02/refatoracao%2Frefatoracao%2Fsrc%2Fmain%2Fjava%2Fcom%2Frefatoracao%2FUsuario.java.
(8) github.com. https://github.com/pettomartino/coursera-ita-java-oo/tree/3aafdcd4cf76e804481ec7cd643b725d1126fcb8/tdd%2Fsemana-2%2Fsrc%2FpSABbyCRC_UnitTestingSuite%2FUsuario.java.
(9) github.com. https://github.com/lssdeveloper/curso-ita-tdd/tree/3dbe8c347078af3fb3d9b24e07ca38491b45f5ce/Semana2_RefatorarSAB%2Fsrc%2FpSABbyCRC_UnitTestingSuite%2FUsuario.java.