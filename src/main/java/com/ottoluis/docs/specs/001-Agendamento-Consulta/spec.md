# Especificação de funcionalidade: [Agendamento de consulta]

**ID:** SPEC-[001]  
**Status:** Pendente Validação com o PO
**Responsáveis:** [Otto Luís, Luiz Felipe, Victor Raphael, Rafael Loureiro, Wellington Perovano]  
**Última atualização:** [30/09/2026]

## 1. Problema e evidências

**Usuário prioritário:** [Pessoas/pacientes que necessitam ou tem interesse em receber tratamento psicológico.]  
**Situação:** [A pessoa/paciente precisa encontrar um psicólogo para se consultar que se encaixe dentro das necessidades dela, podendo ser necessidades geográficas, financeiras e de tempo.]  
**Problema:** [Procurar por clinicas psicológicas ou psicólogos pode ser difícil tendo em vista que as informações sobre eles podem estar dispersas, ser extensas e de difícil filtragem quanto a localização, atendimento por plano, valores cobrados, horários de atendimento e especialidades.]  
**Alternativa atual:** [Pesquisa manual através da internet e contato direto com clinicas psicológicas, recomendações de conhecidos.]  
**Impacto:** [Desestimula a pessoa/paciente a buscar o atendimento medico necessário, demora para conseguir o atendimento médico, risco de um atendimento médico de baixa qualidade, risco a saúde mental da pessoa/paciente.]  
**Evidências disponíveis:** [Documentos institucionais escolhidos pelo professor/PO para compor o banco de dados de clinicas psicológicas e psicólogos cadastrados na aplicação.]  
**Suposições ainda não confirmadas:** [A funcionalidade reduzirá o tempo necessário para a busca e agendamento de consultas em clinicas psicológicas ou com psicólogos, ideais para as necessidades da pessoa/paciente a ser atendida.]

## 2. Objetivo e resultado esperado

**Objetivo:** [Permitir que a pessoa/paciente encontre uma clinica psicológica ou psicólogo ideal de acordo com as necessidades dela tendo em vista questões de localização, atendimento por plano, valores cobrados, horários de atendimento e especialidades.]  
**Hipótese:** [Acreditamos que o nosso sistema de busca e agendamento com o auxílio de IA ajudará a pessoa/paciente a encontrar uma clinica psicológica ou psicólogo de forma mais rápida e que melhor se enquadre nas necessidades dessa pessoa/paciente.] 
**Linha de base:** [Localizar as informações necessárias para verificação diretamente no banco de dados da aplicação relacionada as clinicas psicológicas e psicólogos cadastrados na aplicação, documentos fornecidos pelo PO.]  
**Sinais de sucesso:** [Toda busca de deve apresentar documento e localização, buscas sem resultados possíveis dentro dos documentos disponíveis não devem receber respostas inventadas, o tempo de resposta para as buscas deve ser o mínimo possivel.]

## 3. História prioritária

Como pessoa/paciente que precisa de um atendimento psicológico, quero ter a capacidade de buscar por clinicas psicológicas e psicólogos de forma mais simples em um só lugar, sendo capaz de filtrar minha busca para um lugar especifico, que aceite planos específicos, que atenda de acordo com uma certa faixa de preço, que atenda de acordo com uma certa faixa de horário, e que possua certas especialidades, para dessa forma conseguir agendar minhas consultas com uma clinica psicológica ou psicólogo que melhor atenda minhas necessidade tanto medicas quanto financeiras, geográficas e de tempo.

**Prioridade:** P1  
**Teste independente:** [Cinco buscas com diferentes filtragens preparadas pelo PO, incluindo uma sem resposta no conjunto de documentos das clinicas e especialistas cadastradas na aplicação.]

## 4. Escopo

### Incluído
 
- [Capacidade de filtrar as buscas por clinicas/especialistas em localização geográfica, se aceitam plano, custo cobrado (Caso seja particular), horários de atendimento, especialidades.]
- [Permitir que o paciente agende a consulta antecipadamente, assim como cancelar consultas desde de que de ao menos 24 horas antes.]
- [Informar a fonte da clinica/especialista resultante de uma busca para o usuário checar informações diretamente se desejar, utilizando estritamente as informações do documento de clinicas e especialistas cadastradas na aplicação que foram disponibilizados pelo PO.]
- [Informar de formar clara quando não houver uma clinica ou especialista que se encaixe nos padrões de filtragem informados na busca.]
- [A aplicação apenas funcionará em português brasileiro]
- [A aplicação é feita especificamente para pessoas/pacientes que precisam ou tem interesse em receber acompanhamento médico para saúde mental e suas áreas especificas.]

### Fora do escopo

- [Esse sistema não realiza consultas para clinicas ou especialistas de outras áreas da medicina, seu foco é exclusivamente a área da saude mental.]
- [O sistema não irá realizar atendimentos como se fosse um psicólogo, ele é uma ferramenta de auxílio a busca e agendamento de consultas nada.]
- [IO sistema não tem permissão para consultar fontes externas sem aprovação do PO.]
- [Substituir informações oficiais caso houver conflito nos documentos que compõem sua base de dados.]
- [Os pacientes não poderá acessar dados quanto as consultas de outros pacientes.]
- [Os paciente não poderá cadastrar clinicas psicológicas ou psicólogos.]

## 5. Entradas, saídas e fluxo

*
## 5. Entradas, saídas e fluxo

### Entradas

- Dados de cadastro do usuário:
    - Nome
    - E-mail
    - Senha
    - CPF
    - Data de nascimento
    - Endereço
    - Contato
    - Contato de confiança
- Dados dos psicólogos:
    - Nome
    - CRP
    - Especialidade
    - Contato
    - Rede Social
    - Informações profissionais
- Dados das consultas:
    - Usuário
    - Psicólogo
    - Data
    - Horário
    - Status
    - Observação
    - Link de atendimento
- Credenciais de autenticação:
    - E-mail
    - Senha
    - Token JWT
- Requisições realizadas pela aplicação web ou por clientes da API.

### Saídas

- Cadastro e autenticação de usuários.
- Listagem de psicólogos disponíveis.
- Consulta de informações dos psicólogos.
- Agendamento de consultas.
- Atualização do status das consultas.
- Informações sobre consultas agendadas.
- Geração e validação de token JWT.
- Respostas HTTP em formato JSON.
- Link para atendimento psicológico online.
- Mensagens de erro e validação quando uma operação não pode ser realizada.

### Precondições

- A aplicação deve estar em execução.
- O banco de dados PostgreSQL deve estar disponível.
- O usuário deve estar autenticado para acessar funcionalidades protegidas.
- Os dados enviados devem respeitar as regras de validação da aplicação.
- Para realizar uma consulta, deve existir um usuário e um psicólogo válidos.
- Para realizar um agendamento, os dados de data e horário devem ser válidos.

---

## Fluxo principal

1. **Usuário acessa a aplicação**
    - O sistema disponibiliza as funcionalidades de cadastro, login, consulta de psicólogos e gerenciamento de consultas.

2. **Usuário realiza o cadastro**
    - O sistema recebe os dados pessoais e credenciais.
    - Os dados são validados.
    - A senha é armazenada de forma segura utilizando criptografia/hash.
    - O usuário é registrado no banco de dados.

3. **Usuário realiza o login**
    - O sistema recebe e-mail e senha.
    - As credenciais são verificadas.
    - Caso sejam válidas, o sistema gera um token JWT.
    - O token é utilizado para autenticar as próximas requisições.

4. **Usuário consulta os psicólogos**
    - O sistema recebe a requisição autenticada.
    - Busca os psicólogos cadastrados.
    - Retorna as informações disponíveis em formato JSON.

5. **Usuário seleciona um psicólogo**
    - O sistema recebe a identificação do psicólogo.
    - Verifica se o psicólogo existe.
    - Disponibiliza as informações necessárias para a realização do agendamento.

6. **Usuário agenda uma consulta**
    - O sistema recebe o psicólogo, data, horário e demais informações da consulta.
    - Valida os dados enviados.
    - Registra a consulta no banco de dados.
    - A consulta é criada com seu respectivo status.
    - O sistema retorna os dados da consulta criada.

7. **Usuário consulta seus agendamentos**
    - O sistema identifica o usuário autenticado.
    - Busca suas consultas cadastradas.
    - Retorna as consultas e seus respectivos dados.

8. **Usuário acessa o atendimento**
    - Quando disponível, o sistema fornece o link de atendimento associado à consulta.
    - O usuário pode utilizar o link para realizar o atendimento psicológico online.

---

## Alternativas e erros

### Ausência de informação

- Caso um campo obrigatório não seja informado, o sistema rejeita a requisição.
- O sistema retorna uma mensagem indicando os dados necessários para concluir a operação.

### Entrada inválida

- Caso os dados enviados não estejam de acordo com as regras de validação, a operação não é realizada.
- O sistema retorna uma resposta de erro informando a inconsistência encontrada.

### Usuário não autenticado

- Caso o usuário tente acessar um recurso protegido sem autenticação válida, o sistema bloqueia a requisição.
- É retornado o status HTTP `401 Unauthorized`.

### Usuário sem permissão

- Caso o usuário esteja autenticado, mas não possua a permissão necessária para acessar determinado recurso, o sistema bloqueia a operação.
- É retornado o status HTTP `403 Forbidden`.

### Recurso inexistente

- Caso o usuário solicite um psicólogo, usuário ou consulta que não exista, o sistema informa que o recurso não foi encontrado.
- É retornado o status HTTP `404 Not Found`.

### E-mail já cadastrado

- Caso o usuário tente realizar um cadastro utilizando um e-mail já existente, o sistema rejeita a operação.
- Uma mensagem informa que o e-mail já está cadastrado.

### Credenciais inválidas

- Caso o e-mail ou senha informados no login estejam incorretos, o sistema não gera o token JWT.
- A autenticação é recusada.

### Serviço indisponível

- Caso o banco de dados ou outro componente necessário esteja indisponível, a operação não é concluída.
- O sistema retorna uma resposta de erro apropriada e registra o problema para análise.

### Consulta inválida

- Caso os dados da consulta sejam inválidos ou estejam incompletos, o agendamento não é realizado.
- O sistema informa quais dados precisam ser corrigidos.

### Limite de segurança

- Endpoints protegidos exigem autenticação por JWT.
- As permissões de acesso são controladas de acordo com o perfil do usuário.
- Senhas não são armazenadas em texto puro.
- Dados inválidos ou requisições não autorizadas são rejeitados antes de executar operações protegidas.

### Fluxo principal

1. [ação ou evento]
2. [comportamento do sistema]
3. [resultado entregue ao usuário]

### Alternativas e erros

- [ausência de informação]
- [entrada inválida]
- [serviço indisponível]
- [limite de segurança]

## 6. Requisitos funcionais

- **RF-001:** O sistema deverá [comportamento observável].
- **RF-002:** Quando [evento], o sistema deverá [resposta].
- **RF-003:** Enquanto [estado], o sistema deverá [resposta].

## 7. Critérios de aceitação

### CA-001 — [nome do cenário]

**Dado** [estado inicial]  
**Quando** [evento ou ação]  
**Então** [resultado observável]

### CA-002 — [nome do cenário de falha]

**Dado** [estado inicial]  
**Quando** [evento ou ação]  
**Então** [resposta segura e observável]

## 8. Qualidade, riscos e decisões

**Requisitos de qualidade:** [tempo, segurança, acessibilidade, privacidade ou custo]  
**Riscos principais:** [erro e consequência]  
**Mitigações:** [limite, revisão, confirmação ou fallback]  
**Questões para o PO:** [perguntas que mudam prioridade ou comportamento]  
**Decisões confirmadas:** [decisão, data e responsável]  
**Testes relacionados:** [IDs ou links]
