# 📚 Livraria API RESTful

Uma API RESTful completa para gerenciamento de livros e autores em um sistema de livraria. Este projeto é um exemplo prático de uma aplicação CRUD (Create, Read, Update, Delete) utilizando Spring Boot.

## 🚀 Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3
* **Persistência:** Spring Data JPA & Hibernate
* **Banco de Dados:** H2 Database (para ambiente de teste e desenvolvimento)
* **Auxiliares:** Lombok
* **Estrutura:** Arquitetura em camadas (Controller, Service, Repository, Model)

## 📌 Estrutura do Projeto

O projeto segue a arquitetura em camadas padrão do Spring, garantindo a separação de responsabilidades:

1.  **`model`**: Contém as entidades JPA (`Autor` e `Livro`) que mapeiam as tabelas do banco de dados.
2.  **`repository`**: Interfaces que estendem `JpaRepository`, permitindo operações CRUD diretas no banco de dados.
3.  **`service`**: Contém a **lógica de negócios**, manipulando os dados e aplicando regras (ex: verifica se a entidade existe antes de atualizar).
4.  **`controller`**: Camada de **apresentação REST**, que lida com as requisições HTTP e delega as tarefas para a camada de Serviço.
5.  **`controller.exception`**: Implementação de tratamento de erros customizado (`@RestControllerAdvice`) para retornar respostas HTTP adequadas (ex: 404 Not Found).

## 💡 Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github](https://docs.github.com/pt/migrations/importing-source-code/using-the-command-line-to-import-source-code/adding-locally-hosted-code-to-github)
    cd livraria-api
    ```

2.  **Configure o ambiente (Opcional):**
    O projeto está configurado para usar o perfil `test`, que utiliza o banco de dados em memória **H2** e carrega dados iniciais através da classe `TestConfig` (implements `CommandLineRunner`).

    Para executar com o perfil `test`, certifique-se de que a propriedade `spring.profiles.active=test` esteja configurada.

3.  **Execute a aplicação:**
    Use a sua IDE (IntelliJ, Eclipse) ou o Maven/Gradle:
    ```bash
    # Usando Maven
    ./mvnw spring-boot:run
    ```

## 🌐 Endpoints da API

A API é acessível através do caminho base `/autor` e `/livros`.

| Recurso | Método HTTP | Endpoint | Descrição | Status de Sucesso |
| :--- | :--- | :--- | :--- | :--- |
| **Livro** | `POST` | `/livros` | Cria um novo livro. | `201 Created` |
| **Livro** | `GET` | `/livros` | Lista todos os livros. | `200 OK` |
| **Livro** | `GET` | `/livros/{id}` | Busca um livro por ID. | `200 OK` |
| **Livro** | `PUT` | `/livros/{id}` | Atualiza um livro existente. | `200 OK` |
| **Livro** | `DELETE` | `/livros/{id}` | Deleta um livro por ID. | `204 No Content` |
| **Autor** | `POST` | `/autor` | Cria um novo autor. | `201 Created` |
| **Autor** | `GET` | `/autor` | Lista todos os autores. | `200 OK` |

### Exemplo de Requisição (POST Livro)

Para criar um novo livro e associá-lo a um autor já existente (ID 1, criado no `TestConfig`), envie um JSON para o endpoint: `POST http://localhost:8080/livros`

```json
{
    "nome": "O Guia do Mochileiro das Galáxias",
    "autor": {
        "id": 1 
    }
}
🛑 Tratamento de Exceções
O projeto inclui um ControllerExceptionHandler que captura a exceção customizada EntityNotFound.

Se você tentar buscar um livro ou autor que não existe, a API retornará o status HTTP 404 Not Found com um corpo de erro detalhado.

JSON

{
    "timestamp": "2025-11-11T20:00:00Z",
    "status": 404,
    "error": "Not Found",
    "message": "Livro do id: 999 Não encontrado",
    "path": "/livros/999"
}
