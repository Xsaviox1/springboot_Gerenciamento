# Sistema de Gerenciamento para o Bradesco

Este projeto foi desenvolvido para atender às necessidades do Bradesco, com foco na gestão eficiente de **Departamentos**, **Titulares** e suas respectivas interações. A aplicação foi construída utilizando **Java** com o framework **Spring Boot**, oferecendo APIs RESTful para facilitar o gerenciamento de dados.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot** (API REST)
- **Spring Data JPA** (Integração com banco de dados)
- **Hibernate** (ORM)
- **Lombok** (Redução de boilerplate no código)
- **Banco de Dados Relacional** (MySQL ou PostgreSQL, conforme configuração)
- **Maven** (Gerenciador de dependências)

## Estrutura do Projeto
O projeto segue uma arquitetura em camadas, dividida da seguinte forma:

- **`domain`**: Contém as classes principais do domínio do sistema:
  - **Entities**: Representam as tabelas do banco de dados, como `Departamento` e `Titular`.
  - **DTO (Data Transfer Object)**: Objetos para transporte de dados entre camadas.
  - **Enums**: Define constantes como `TipoDepartamento` (DEPARTAMENTO1, DEPARTAMENTO2, DEPARTAMENTO3).
- **`repository`**: Classes responsáveis pela interação com o banco de dados.
- **`service`**: Implementa a lógica de negócios, como validações e manipulação de dados.
- **`application`**: Contém os controladores REST, responsáveis por expor as APIs.

## Requisitos para Execução
- **Java 17** ou superior
- **Maven** configurado
- Banco de dados configurado (MySQL, PostgreSQL, etc.)
- Ferramenta para testes de API (Postman, Insomnia, etc.)

### Configuração do Banco de Dados
Atualize o arquivo `application.properties` com as configurações do banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
spring.datasource.username=usuario
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Clone o repositório:

bash
Copiar código
git clone https://github.com/seu-usuario/bradesco-management-system.git
cd bradesco-management-system
Compile e instale as dependências:

bash
Copiar código
mvn clean install
Execute a aplicação:

bash
Copiar código
mvn spring-boot:run
Acesse a API em http://localhost:8080.
```
## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/Xsaviox1/springboot_Gerenciamento
   cd springboot_Gerenciamento
2. Compile e instale as dependências:
   ```bash
   mvn clean install
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
