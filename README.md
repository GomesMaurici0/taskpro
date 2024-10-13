
# TaskTrack PRO - API RESTful

Este projeto é uma evolução do [TaskTrack](https://github.com/GomesMaurici0/TaskTrack), criado para aperfeiçoar e aprofundar conhecimentos em **Java 17**, **Spring Boot**, **Spring Security**, **JPA** e **testes unitários com JUnit**.

## Status do Projeto
🚧 Em desenvolvimento 🚧

## Objetivo

O objetivo deste projeto é aprimorar as práticas adquiridas durante o desenvolvimento do TaskTrack original, agregando funcionalidades mais robustas e seguras, além de promover a integração de novos conceitos, como:

- **Autenticação e Autorização**: Implementação de Spring Security para garantir maior segurança nas APIs.
- **Relacionamentos JPA**: Gestão de relacionamentos entre entidades (One-to-One, One-to-Many, Many-to-Many) utilizando JPA.
- **Testes Unitários**: Testes de unidades com JUnit para validar o comportamento da aplicação e garantir sua estabilidade.
  
## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Security**
- **JPA / Hibernate**
- **JUnit 5**
- **Maven**

## Funcionalidades Planejadas

- [ ] Sistema de gerenciamento de tarefas com CRUD (Create, Read, Update, Delete)
- [ ] Autenticação e autorização com Spring Security (JWT)
- [ ] Relacionamento entre usuários e empresas com JPA
- [ ] Testes unitários e de integração com JUnit
- [ ] Documentação com Swagger/OpenAPI

## Como Executar

### Pré-requisitos
- **Java 17** deve estar instalado.
- **Maven** para gerenciar dependências.

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/taskpro.git
   ```

2. Entre no diretório do projeto:

   ```bash
   cd taskpro
   ```

3. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API através de `http://localhost:8080`.

## Estrutura do Projeto

- `src/main/java`: Contém a lógica da aplicação.
- `src/test/java`: Contém os testes unitários do projeto.
- `resources`: Contém os arquivos de configuração (ex: `application.properties`).

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções e sugestões!

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT).
