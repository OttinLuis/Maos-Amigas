# Mãos Amigas

API REST desenvolvida com Java e Spring Boot para uma plataforma de apoio psicológico, conectando usuários a profissionais da área de psicologia e permitindo o gerenciamento de consultas.

O projeto foi desenvolvido com foco em boas práticas de desenvolvimento backend, organização em camadas, persistência de dados, validação e segurança da aplicação.

## Tecnologias

* Java 24
* Spring Boot 4.1.1
* Spring Web MVC
* Spring Data JPA
* Hibernate
* PostgreSQL
* Spring Security
* Bean Validation
* Maven
* Docker
* Postman

## Funcionalidades

### Usuários

* Cadastro de usuários
* Atualização de dados
* Consulta de usuários
* Exclusão de usuários
* Validação dos dados recebidos
* Autenticação utilizando Spring Security
* Senhas armazenadas de forma segura

### Psicólogos

* Cadastro e gerenciamento de psicólogos
* Identificação profissional através do CRP
* Consulta dos profissionais disponíveis
* Associação entre usuários e psicólogos

### Consultas

* Agendamento de consultas
* Associação entre usuário e psicólogo
* Definição de data e horário
* Controle do status da consulta
* Geração e gerenciamento de dados relacionados à consulta

## Arquitetura

O projeto utiliza uma arquitetura organizada em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

Também são utilizados DTOs e Mappers para separar os objetos de entrada/saída das entidades persistidas no banco.

### Estrutura

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── ottoluis/
    │           └── MaosAmigas/
    │               ├── config/
    │               ├── controller/
    │               ├── dto/
    │               ├── mapper/
    │               ├── models/
    │               ├── repository/
    │               └── services/
    │
    └── resources/
```

## Principais conceitos utilizados

O projeto aplica conceitos importantes do desenvolvimento backend com Java:

* Programação Orientada a Objetos
* REST API
* DTO
* Mapper
* Injeção de dependência
* Spring Data JPA
* Hibernate
* Relacionamentos entre entidades
* Validação de dados
* Autenticação e autorização
* Spring Security
* Persistência com PostgreSQL
* Arquitetura em camadas

## Banco de dados

O projeto utiliza PostgreSQL como banco de dados e Spring Data JPA/Hibernate para o mapeamento objeto-relacional.

As entidades são relacionadas através de associações JPA, permitindo o gerenciamento dos usuários, psicólogos e consultas.

## Segurança

A aplicação utiliza Spring Security para controle de acesso e autenticação.

As credenciais dos usuários não são armazenadas em texto puro. O sistema utiliza mecanismos de hash para proteger as senhas.

## Docker

O projeto possui arquivos de configuração para execução utilizando Docker:

```text
Dockerfile
docker-compose.yml
```

Isso permite facilitar a configuração do ambiente de desenvolvimento e a execução dos serviços necessários para a aplicação.

## Como executar

### 1. Clone o repositório

```bash
git clone https://github.com/OttinLuis/Maos-Amigas.git
```

### 2. Entre no projeto

```bash
cd Maos-Amigas
```

### 3. Configure o banco PostgreSQL

Crie um banco de dados PostgreSQL e configure as credenciais da aplicação de acordo com o seu ambiente.

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5433/MaosAmigas
spring.datasource.username=postgres
spring.datasource.password=sua_senha
```

### 4. Execute a aplicação

No macOS/Linux:

```bash
./mvnw spring-boot:run
```

Ou, caso esteja utilizando Maven instalado:

```bash
mvn spring-boot:run
```

A API será disponibilizada em:

```text
http://localhost:8080
```

## Testando a API

A API pode ser testada utilizando ferramentas como:

* Postman
* Insomnia
* Swagger/OpenAPI

O projeto também possui arquivos relacionados às coleções do Postman.

## Objetivo do projeto

O Mãos Amigas foi desenvolvido como um projeto acadêmico e de portfólio com o objetivo de aplicar, na prática, conceitos de desenvolvimento backend utilizando Java e Spring Boot.

O projeto também serve como experiência prática com APIs REST, bancos de dados relacionais, segurança, arquitetura em camadas e desenvolvimento de aplicações backend.


## Repositório

[GitHub — Mãos Amigas](https://github.com/OttinLuis/Maos-Amigas)
