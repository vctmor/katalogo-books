Para testar a classe `Client` utilizando o JUnit, você pode criar uma classe de teste separada que verificará o comportamento dos métodos principais, como o construtor que recebe um `ClientRegister`, o método `updateData`, e o método `logicalDeletion`.


### Explicação dos Testes:

1. **Testando o Construtor:**
   - Criamos um mock de `ClientRegister` para simular os dados que seriam passados ao construtor do `Client`.
   - Verificamos se os valores atribuídos ao `Client` correspondem aos valores fornecidos pelo mock.

2. **Testando o Método `updateData`:**
   - Criamos um mock de `ClientUpdate` para simular os novos dados.
   - Verificamos se o `Client` atualiza corretamente os seus atributos baseados nos novos dados.

3. **Testando o Método `logicalDeletion`:**
   - Verificamos se o método `logicalDeletion` altera o estado do atributo `active` para `false`.

### Considerações:
- **Mockito** é utilizado para criar mocks de `ClientRegister` e `ClientUpdate`. Se preferir, você pode criar instâncias reais dessas classes em vez de utilizar mocks, mas os mocks permitem maior controle sobre o comportamento para testes.
- **JUnit Assertions** (`assertEquals`, `assertTrue`, `assertFalse`) são usados para verificar se o estado do objeto `Client` é o esperado após cada operação.


### Passos para criar os testes:

1. **Verificar o comportamento do construtor:**
   - Testar se os valores passados pelo `ClientRegister` são atribuídos corretamente aos atributos da classe `Client`.
   - Testar se o campo `active` é inicializado corretamente como `true`.

2. **Verificar o método `updateData`:**
   - Testar se os campos são atualizados corretamente quando valores válidos são passados.
   - Testar o comportamento quando campos nulos são passados.

3. **Verificar o método `logicalDeletion`:**
   - Testar se o campo `active` é corretamente definido como `false`.

### Classe de Teste:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testClientConstructor() {
        // Arrange
        ClientRegister data = mock(ClientRegister.class);
        when(data.name()).thenReturn("John Doe");
        when(data.cpf()).thenReturn("123.456.789-00");
        when(data.email()).thenReturn("john.doe@example.com");
        when(data.phone()).thenReturn("1234567890");

        // Act
        Client client = new Client(data);

        // Assert
        assertEquals("John Doe", client.getName());
        assertEquals("123.456.789-00", client.getCpf());
        assertEquals("john.doe@example.com", client.getEmail());
        assertEquals("1234567890", client.getPhone());
        assertTrue(client.isActive());
    }

    @Test
    void testUpdateData() {
        // Arrange
        ClientRegister initialData = mock(ClientRegister.class);
        when(initialData.name()).thenReturn("John Doe");
        when(initialData.cpf()).thenReturn("123.456.789-00");
        when(initialData.email()).thenReturn("john.doe@example.com");
        when(initialData.phone()).thenReturn("1234567890");

        Client client = new Client(initialData);

        ClientUpdate updateData = mock(ClientUpdate.class);
        when(updateData.name()).thenReturn("Jane Doe");
        when(updateData.email()).thenReturn("jane.doe@example.com");
        when(updateData.phone()).thenReturn("0987654321");
        when(updateData.active()).thenReturn(false);

        // Act
        client.updateData(updateData);

        // Assert
        assertEquals("Jane Doe", client.getName());
        assertEquals("jane.doe@example.com", client.getEmail());
        assertEquals("0987654321", client.getPhone());
        assertFalse(client.isActive());
    }

    @Test
    void testLogicalDeletion() {
        // Arrange
        ClientRegister data = mock(ClientRegister.class);
        when(data.name()).thenReturn("John Doe");
        when(data.cpf()).thenReturn("123.456.789-00");
        when(data.email()).thenReturn("john.doe@example.com");
        when(data.phone()).thenReturn("1234567890");

        Client client = new Client(data);

        // Act
        client.logicalDeletion();

        // Assert
        assertFalse(client.isActive());
    }
}
```

Certifique-se de que todos os mocks e dependências necessárias estejam configurados corretamente no seu ambiente de testes para evitar erros de execução.