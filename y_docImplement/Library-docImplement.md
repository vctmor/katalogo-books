Para implementar a classe `Biblioteca`, você precisará considerar os seguintes requisitos e informações:

**Estrutura de Dados**:
   - Livros são armazenados em um `TreeSet<Livro>`, garantindo ordenação.
   - Usuários são armazenados em um `HashSet<Usuario>`, garantindo unicidade.

### Informações Adicionais

- **Atributos Privados**:
  - `_nome`: Nome da biblioteca.
  - `_nrUnico`: Contador para gerar números únicos para os livros.
  - `_repositorioLivros`: Repositório de livros (`TreeSet<Livro>`).
  - `_usuarios`: Conjunto de usuários (`HashSet<Usuario>`).

- **Construtor**:
  - `Library(String nome)`: Inicializa a biblioteca com um nome, um repositório de livros (`TreeSet<Livro>`) e um conjunto de usuários (`HashSet<Usuario>`).

- **Método Privado**:
  - `getNrUnico()`: Gera um número único para cada livro adicionado ao catálogo.


### Requisitos Funcionais

1. **Adicionar Livro ao Catálogo**:
   - Método: `adicionaLivroCatalogo(Livro livro)`
   - Exceções: `AdicionarLivroInexistenteException`
   - Descrição: Adiciona um livro ao catálogo, atribuindo um número único ao livro.

2. **Registrar Usuário**:
   - Método: `registraUsuario(String nome)`
   - Exceções: `UsuarioJaRegistradoException`, `UsuarioComNomeVazioException`, `UsuarioInexistenteException`
   - Descrição: Registra um novo usuário na biblioteca.

3. **Emprestar Livro**:
   - Método: `emprestaLivro(Livro livro, Usuario usuario)`
   - Exceções: `LivroIndisponivelParaEmprestimoException`, `LivroOuUsuarioNulosException`
   - Descrição: Empresta um livro a um usuário, se o livro estiver disponível.

4. **Devolver Livro**:
   - Método: `devolveLivro(Livro livro)`
   - Exceções: `DevolveLivroDisponivelParaEmprestimoException`, `DevolveLivroNuloParaEmprestimoException`
   - Descrição: Devolve um livro emprestado.

5. **Buscar Livro por Número de Catálogo**:
   - Método: `buscaLivroPorNrCatalogo(int nrUnico)`
   - Descrição: Busca um livro pelo seu número de catálogo.

6. **Buscar Livro por Título e Autor**:
   - Método: `buscaLivroPorTituloAutor(String titulo, String autor)`
   - Exceções: `TituloOuAutorVazioException`, `TituloOuAutorNuloException`
   - Descrição: Busca um livro pelo título e autor.

7. **Buscar Usuário por Nome**:
   - Método: `buscaUsuarioPorNome(String nome)`
   - Exceções: `BuscaUsuarioComNomeVazioException`, `BuscaUsuarioComNomeNuloException`
   - Descrição: Busca um usuário pelo nome.

8. **Exibir Livros Disponíveis**:
   - Método: `exibeLivrosDisponiveis()`
   - Descrição: Exibe todos os livros disponíveis para empréstimo.

9. **Exibir Livros Emprestados**:
   - Método: `exibeLivrosEmprestados()`
   - Descrição: Exibe todos os livros que estão emprestados.

10. **Exibir Usuários**:
    - Método: `exibeUsuarios()`
    - Descrição: Exibe todos os usuários registrados na biblioteca.

### Requisitos Não Funcionais

 **Exceções Personalizadas**:
   - `AdicionarLivroInexistenteException`
   - `UsuarioJaRegistradoException`
   - `UsuarioComNomeVazioException`
   - `UsuarioInexistenteException`
   - `LivroIndisponivelParaEmprestimoException`
   - `LivroOuUsuarioNulosException`
   - `DevolveLivroDisponivelParaEmprestimoException`
   - `DevolveLivroNuloParaEmprestimoException`
   - `TituloOuAutorVazioException`
   - `TituloOuAutorNuloException`
   - `BuscaUsuarioComNomeVazioException`
   - `BuscaUsuarioComNomeNuloException`



### Exemplo de Implementação

Aqui está um exemplo de como você pode começar a implementar a classe `Biblioteca`:

```java
package pSABbyCRC_UnitTestingSuite;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Biblioteca {

    private String _nome;
    private int _nrUnico = 0;
    private TreeSet<Livro> _repositorioLivros;
    private HashSet<Usuario> _usuarios;

    public Biblioteca(String nome) {
        _nome = nome;
        _repositorioLivros = new TreeSet<Livro>();
        _usuarios = new HashSet<Usuario>();
    }

    private int getNrUnico() {
        return _nrUnico = _nrUnico + 1;
    }

    public void adicionaLivroCatalogo(Livro livro) throws AdicionarLivroInexistenteException {
        if (livro != null) {
            livro.setNrCatalogo(this.getNrUnico());
            _repositorioLivros.add(livro);
        } else {
            throw new AdicionarLivroInexistenteException("--->Não pode adicionar livro inexistente!");
        }
    }

    // Outros métodos...

}
```

Espero que isso ajude você a entender melhor como implementar a classe `Biblioteca`! Se precisar de mais detalhes ou tiver outras dúvidas, estou aqui para ajudar.

Fonte: conversa com o Copilot, 27/07/2024
(1) extends class and implements interface in java - Stack Overflow. https://stackoverflow.com/questions/14021827/extends-class-and-implements-interface-in-java.
(2) java - What does "implements" do on a class? - Stack Overflow. https://stackoverflow.com/questions/4558111/what-does-implements-do-on-a-class.
(3) Java Class and Objects (With Example) - Programiz. https://www.programiz.com/java-programming/class-objects.
(4) Implementing an Interface - Dev.java. https://dev.java/learn/interfaces/examples/.
(5) Implementing an Interface (The Java™ Tutorials > Learning the Java .... https://docs.oracle.com/javase/tutorial/java/IandI/usinginterface.html.
(6) undefined. http://www.java2s.com/Code/Php/Class/extendsandimplement.htm.