# **Spring Boot Auth API**

## **Descrição do Projeto**
Esta é uma API Rest que fornece um CRUD para gerenciamento de produtos desenvolvida em **Java** utilizando o **Spring Boot**. A aplicação oferece funcionalidades como criação e gerenciamento de produtos e usuarios, além de autenticação segura baseada em **JWT (JSON Web Token)**. 

O objetivo deste projeto é demonstrar habilidades em desenvolvimento backend moderno, incluindo segurança, persistência de dados, documentação e testes.

---

## **Índice**
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Funcionalidades](#funcionalidades)
- [Como Executar](#como-executar)
  - [Pré-requisitos](#pré-requisitos)
  - [Instalação](#instalação)
  - [Executando o Projeto](#executando-o-projeto)
- [Commits Semânticos](#commits-semânticos)
- [Endpoints da API](#endpoints-da-api)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## **Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Security
  - Spring Validation
- **PostgreSQL** como banco de dados relacional
- **JWT** para autenticação
- **JUnit 5** e **Mockito** para testes
- **Springdoc OpenAPI** para documentação da API (Swagger UI)
- **Maven** como gerenciador de dependências
- **Lombok** para reduzir boilerplate de código

---

## **Funcionalidades**
1. **Gerenciamento de Produtos**
   - Cadastro, atualização, deleção e recuperação de produtos.
   
2. **Gerenciamento de usuários**
   - Criação de usuários
   - Login com autenticação baseada em token JWT.
   - Gerenciamento de perfis (usuário ou administrador).

3. **Segurança**
   - Proteção de endpoints com autenticação e autorização.
   - Controle de acesso baseado em papéis (**ROLE_USER**, **ROLE_ADMIN**).

4. **Documentação da API (Em desenvolvimento)**
   - Documentação automática gerada pelo Springdoc OpenAPI, acessível via Swagger UI.

5. **Testes Automatizados (Em desenvolvimento)**
   - Testes unitários para validação das regras de negócio.
   - Testes de integração para endpoints e banco de dados.

---

## **Como Executar**

### **Pré-requisitos**
Antes de começar, certifique-se de ter instalado:
- **Java 17**
- **Maven**
- **Docker** (opcional, para executar o banco de dados PostgreSQL via container)
- Uma IDE como **IntelliJ IDEA** ou **Eclipse**

### **Instalação**
1. Clone este repositório:
```bash
   git clone https://github.com/MatheusHBMelo/springboot-auth-api.git
   cd springboot-auth-api
```
2. Configure o banco de dados PostgreSQL:

-   Certifique-se de que o PostgreSQL esteja rodando localmente.
-   Crie um banco de dados chamado `auth_api`.
-   Atualize as credenciais no arquivo `application.properties`.

```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/auth_api 
   spring.datasource.username=seu-usuario 
   spring.datasource.password=sua-senha
```
3. Compile o projeto:

```bash
   mvn clean install
```

### Executando o Projeto

- Inicie o servidor Spring Boot:

```bash
   mvn spring-boot:run
```
- A aplicação estará disponível em: http://localhost:8080


## **Commits Semânticos**

Adotamos a convenção de **commits semânticos** para manter o histórico do repositório organizado e facilitar o entendimento das mudanças realizadas. Utilize o seguinte padrão para mensagens de commit:

### **Estrutura**
```properties
<tipo>: <descrição breve>
```

### **Tipos de Commit**

-   **feat**: Adição de uma nova funcionalidade.
    -   Exemplo: `feat: adiciona endpoint para criação de contas`
-   **fix**: Correção de bugs.
    -   Exemplo: `fix: corrige erro de autenticação no login`
-   **refactor**: Refatoração de código sem alterar funcionalidades.
    -   Exemplo: `refactor: melhora organização do serviço de transações`
-   **chore**: Alterações menores ou tarefas que não alteram o comportamento do código (e.g., atualizações de dependências).
    -   Exemplo: `chore: atualiza versão do Spring Boot`
-   **docs**: Alterações na documentação.
    -   Exemplo: `docs: adiciona seção sobre commits semânticos no README`
-   **test**: Adição ou modificação de testes.
    -   Exemplo: `test: adiciona teste unitário para o serviço de usuários`
-   **style**: Alterações relacionadas à formatação de código, semântica ou ajustes visuais.
    -   Exemplo: `style: aplica formatação ao código do controller`

## **Endpoints da API**

### Exemplos de Endpoints

#### **Autenticação**

-   `POST /api/v1/auth/register`: Criação de usuários (salva no banco de dados).
-   `POST /api/v1/auth/login`: Autenticação de usuários (retorna token JWT).

#### **Produtos**

-   `POST /api/v1/products`: Criação de novos produtos.
-   `GET /api/v1/products`: Consultar todos os produtos cadastrados. 
-   `GET /api/v1/products/{id}`: Consultar um produto especifico.
-   `PUT /api/v1/products/{id}`: Atualizar um produto especifico.
-   `DELETE /api/v1/products/{id}`: Deletar um produto especifico.

## **Contribuição**

Contribuições são bem-vindas! Siga os passos abaixo:

1.  Faça um fork deste repositório.
2.  Crie uma branch para sua feature ou correção:
```bash
git checkout -b feature/nova-feature 
``` 
3.  Commit suas alterações:
```bash
git commit -m "Adiciona nova funcionalidade"
``` 
4.  Envie suas mudanças:

```bash
git push origin feature/nova-feature
```  
5.  Abra um Pull Request.

## **Licença**

Este projeto está licenciado sob a MIT License.

----------

### **Autor**

**Matheus Barbosa**

-   [LinkedIn](https://www.linkedin.com/in/matheushbmelo)
-   [GitHub](https://github.com/MatheusHBMelo)