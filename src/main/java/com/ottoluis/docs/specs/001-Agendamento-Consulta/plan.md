# Plano de implementação do suporte psicológico online

## Resumo técnico

O Mãos Amigas é uma plataforma de suporte psicológico online que conecta usuários a psicólogos e permite o gerenciamento de consultas psicológicas.

A aplicação é disponibilizada por meio de uma API REST desenvolvida em Java com Spring Boot. O sistema utiliza autenticação e autorização para proteger os recursos e permite que usuários consultem psicólogos

e realizem o agendamento de consultas.

A aplicação é executada em ambiente conteinerizado utilizando Docker Compose, com o gerenciamento dos containers realizado pelo Colima no ambiente de desenvolvimento.

O sistema também poderá utilizar um assistente baseado em inteligência artificial para auxiliar o usuário na busca por atendimento, principalmente na identificação de psicólogos e horários disponíveis. A IA atua como recurso complementar e não substitui o profissional de psicologia.

## Contexto técnico

* **Linguagem:** Java
* **Framework:** Spring Boot
* **API:** REST
* **Banco de dados:** PostgreSQL
* **ORM:** JPA/Hibernate
* **Autenticação:** JWT
* **Autorização:** controle de acesso por perfil
* **Validação:** Bean Validation
* **Documentação da API:** OpenAPI/Swagger
* **Testes:** JUnit e Mockito
* **Frontend:** aplicação web integrada à API REST
* **Containerização:** Docker
* **Orquestração:** Docker Compose
* **Ambiente de containers:** Colima
* **Integração com IA:** serviço externo de modelo de linguagem, quando habilitado, utilizando a key do Groq
* **Configuração:** variáveis de ambiente para credenciais, banco de dados e serviços externos

## Arquitetura

```text
                    Mãos Amigas
                         |
              +----------+----------+
              |                     |
              v                     v
          Frontend              API REST
                                    |
             +----------------------+----------------------+
             |                      |                      |
             v                      v                      v
       Autenticação            Usuários              Psicólogos
             |                      |                      |
             +----------------------+----------------------+
                                    |
                                    v
                              Consultas
                                    |
                                    v
                               PostgreSQL
```

### Ambiente de execução

```text
                    Colima
                      |
                Docker Compose
                      |
             +--------+--------+
             |                 |
             v                 v
        Mãos Amigas        PostgreSQL
           API
```

O Docker Compose é responsável por definir e executar os serviços necessários para o funcionamento da aplicação.

O Colima fornece o ambiente de virtualização utilizado para executar os containers Docker no ambiente de desenvolvimento.

A comunicação entre os containers deve utilizar os nomes dos serviços definidos no `docker-compose.yml`, evitando utilizar `localhost` para comunicação interna entre containers.

## Componentes

### Usuários

Responsável pelo cadastro, autenticação e gerenciamento das informações necessárias para utilização da plataforma.

O acesso aos recursos protegidos é realizado mediante autenticação e autorização por perfil.

### Psicólogos

Responsável pelo cadastro e disponibilização dos profissionais de psicologia na plataforma.

Os usuários podem consultar os psicólogos disponíveis e utilizar essas informações para escolher um profissional.

### Consultas

Responsável pelo gerenciamento dos agendamentos entre usuários e psicólogos.

Uma consulta possui informações como:

* Usuário;
* Psicólogo;
* Data;
* Horário;
* Status;
* Link da consulta, quando disponível.

O sistema deve validar a disponibilidade antes da realização de um novo agendamento.

### Assistente de IA

O assistente de IA funciona como um recurso complementar da plataforma.

Ele poderá auxiliar o usuário a:

* Encontrar psicólogos;
* Consultar disponibilidade;
* Localizar informações sobre consultas;
* Orientar o usuário durante a utilização da plataforma.

A IA não realiza diagnóstico psicológico, não substitui o psicólogo e não deve tomar decisões clínicas.

## Estratégia de avaliação

* Criar casos de teste para cadastro e autenticação de usuários.
* Validar o controle de acesso conforme o perfil do usuário.
* Testar a consulta e listagem de psicólogos.
* Testar o processo completo de agendamento de consultas.
* Validar regras para impedir conflitos de horários.
* Testar alterações de status das consultas.
* Verificar a disponibilização do link da consulta.
* Testar respostas inválidas e dados obrigatórios.
* Avaliar o comportamento da integração com IA quando o serviço estiver indisponível.
* Garantir que uma falha no serviço de IA não impeça o funcionamento das funcionalidades principais.
* Testar a comunicação entre os containers da aplicação.
* Validar a conexão da API com o PostgreSQL dentro da rede do Docker Compose.
* Utilizar testes automatizados para validar as principais regras de negócio.

## Riscos

| Risco                                 | Mitigação                                                   | Verificação                          |
| ------------------------------------- | ----------------------------------------------------------- | ------------------------------------ |
| Acesso não autorizado                 | JWT e controle de permissões por perfil                     | Testes de autenticação e autorização |
| Agendamento em horário ocupado        | Validação de disponibilidade antes da criação               | Testes de conflito de horários       |
| Dados inválidos no cadastro           | Bean Validation e tratamento global de exceções             | Testes de validação                  |
| Psicólogo inexistente                 | Validação da existência do profissional                     | Teste de referência inválida         |
| Consulta inexistente                  | Tratamento adequado de recursos não encontrados             | Teste de consulta inexistente        |
| Falha na integração com IA            | Tratamento de indisponibilidade                             | Testes de indisponibilidade          |
| Exposição de dados sensíveis          | Controle de acesso e retorno apenas dos dados necessários   | Testes de segurança                  |
| Falha na comunicação entre containers | Configuração correta da rede do Docker Compose              | Testes de integração                 |
| API não consegue acessar o banco      | Utilização do nome do serviço PostgreSQL no ambiente Docker | Teste de conexão                     |
| Conflito de porta                     | Definição adequada das portas no Docker Compose             | Verificação dos serviços             |
| Falha no ambiente de containers       | Utilização do Colima e configuração padronizada do Docker   | Teste de inicialização               |
| Erro no status da consulta            | Regras centralizadas no serviço de domínio                  | Testes das transições de status      |

## Estrutura prevista

```text
src/main/java/com/ottoluis/MaosAmigas/
├── controller/
│   ├── UsuarioController.java
│   ├── PsicologosController.java
│   └── ConsultaController.java
│
├── service/
│   ├── UsuarioService.java
│   ├── PsicologosService.java
│   └── ConsultaService.java
│
├── repository/
│   ├── UsuarioRepository.java
│   ├── PsicologoRepository.java
│   └── ConsultaRepository.java
│
├── entity/
│   ├── Usuario.java
│   ├── SuportePsicologico.java
│   └── Consulta.java
│
├── dto/
│   ├── ConsultaCreateDTO.java
│   └── ...
│
├── mapper/
│   └── ConsultaMapper.java
│
├── security/
│   ├── CustomUserDetailsService.java
│   ├── SecurityConfig.java
│   └── ...
│
├── exception/
│   └── GlobalExceptionHandler.java
│
└── config/
    └── OpenApiConfig.java

docker-compose.yml
Dockerfile
```

## Integração futura com IA

```text
Usuário
   |
   v
Assistente de IA
   |
   v
API Mãos Amigas
   |
   +--> Psicólogos disponíveis
   |
   +--> Horários disponíveis
   |
   +--> Consultas
   |
   v
Resposta ao usuário
```

A integração com IA deverá permanecer separada das regras principais do sistema.

O modelo poderá interpretar a solicitação do usuário e auxiliar na busca de informações, enquanto a API continuará responsável por validar disponibilidade, autenticação, autorização e execução das operações.

O sistema não deve permitir que a IA crie, altere ou cancele consultas diretamente sem passar pelas regras de negócio e pelos mecanismos de autorização da API.

## Execução do ambiente

O ambiente de desenvolvimento utiliza Colima como runtime para os containers Docker.

A inicialização dos serviços deve ser realizada por meio do Docker Compose:

```bash
docker compose up -d
```

Para verificar os serviços em execução:

```bash
docker compose ps
```

Para visualizar os logs:

```bash
docker compose logs -f
```

Para encerrar os serviços:

```bash
docker compose down
```

A API e o banco de dados devem ser executados de acordo com a configuração definida no `docker-compose.yml`.

