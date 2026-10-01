# Especificação de funcionalidade: [Agendamento de consulta]

**ID:** SPEC-[001]  
**Status:** Pendente Validação com o PO
**Responsáveis:** [Otto Luís, Luiz Felipe, Victor Raphael, Rafael Loureiro, Wellington Perovano]  
**Última atualização:** [01/10/2026]

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

## 6. Requisitos Funcionais

**RF-001:** O sistema deverá permitir que o usuário realize seu cadastro informando seus dados pessoais e credenciais de acesso.

**RF-002:** Quando o usuário informar credenciais válidas, o sistema deverá realizar sua autenticação e permitir o acesso às funcionalidades correspondentes ao seu perfil.

**RF-003:** Quando o usuário informar credenciais inválidas, o sistema deverá rejeitar a autenticação e informar que os dados de acesso são inválidos.

**RF-004:** O sistema deverá permitir que usuários autenticados consultem os psicólogos disponíveis para atendimento.

**RF-005:** O sistema deverá permitir que o usuário consulte as informações dos psicólogos cadastrados, incluindo dados profissionais e registro no CRP.

**RF-006:** Quando o usuário selecionar um psicólogo, o sistema deverá permitir a consulta das datas e horários disponíveis para atendimento.

**RF-007:** O sistema deverá permitir que o usuário agende uma consulta com um psicólogo em uma data e horário disponíveis.

**RF-008:** Quando uma consulta for agendada, o sistema deverá registrar o usuário, o psicólogo, a data, o horário e o status da consulta.

**RF-009:** O sistema deverá atribuir o status **AGENDADA** às novas consultas.

**RF-010:** O sistema deverá permitir que o usuário consulte suas consultas agendadas e seus respectivos status.

**RF-011:** Quando uma consulta possuir um link de atendimento, o sistema deverá disponibilizar o link ao usuário autorizado.

**RF-012:** O sistema deverá permitir o registro de informações adicionais relacionadas à consulta, quando aplicável.

**RF-013:** O sistema deverá permitir que usuários autorizados alterem o status de uma consulta conforme as regras definidas pelo sistema.

**RF-014:** O sistema deverá impedir o agendamento de uma consulta em horário que não esteja disponível para o psicólogo.

**RF-015:** O sistema deverá impedir o cadastro de mais de um psicólogo utilizando o mesmo número de CRP.

**RF-016:** O sistema deverá impedir o cadastro de mais de um usuário utilizando o mesmo endereço de e-mail.

**RF-017:** O sistema deverá permitir que usuários com perfil administrativo gerenciem os dados dos psicólogos cadastrados.

**RF-018:** O sistema deverá permitir que usuários com perfil administrativo consultem e gerenciem as consultas registradas no sistema.

**RF-019:** Quando uma requisição exigir autenticação, o sistema deverá verificar as credenciais e permissões do usuário antes de permitir o acesso ao recurso.

**RF-020:** Quando um usuário autenticado tentar acessar um recurso sem a permissão necessária, o sistema deverá negar o acesso ao recurso.

**RF-021:** O sistema deverá disponibilizar uma API REST para comunicação entre o sistema e seus clientes.

**RF-022:** O sistema deverá utilizar JSON para representar os dados enviados e recebidos pela API.

**RF-023:** O sistema deverá validar os dados recebidos nas operações de cadastro, atualização e agendamento antes de persistí-los no banco de dados.

**RF-024:** Quando ocorrer uma operação inválida, o sistema deverá retornar uma resposta HTTP compatível com o tipo de erro ocorrido.

---

## 7. Critérios de Aceitação

### CA-001 — Cadastro de usuário

**Dado** que o usuário esteja na tela de cadastro  
**Quando** informar todos os dados obrigatórios válidos e confirmar o cadastro  
**Então** o sistema deverá criar o usuário e permitir sua autenticação.

### CA-002 — Cadastro com e-mail existente

**Dado** que já exista um usuário cadastrado com determinado e-mail  
**Quando** outro usuário tentar utilizar o mesmo e-mail  
**Então** o sistema deverá rejeitar o cadastro e informar que o e-mail já está cadastrado.

### CA-003 — Autenticação válida

**Dado** que o usuário possua uma conta cadastrada  
**Quando** informar e-mail e senha válidos  
**Então** o sistema deverá autenticar o usuário e permitir o acesso aos recursos autorizados.

### CA-004 — Autenticação inválida

**Dado** que o usuário esteja na tela de login  
**Quando** informar credenciais inválidas  
**Então** o sistema deverá rejeitar a autenticação e impedir o acesso aos recursos protegidos.

### CA-005 — Consulta de psicólogos

**Dado** que o usuário esteja autenticado  
**Quando** solicitar a lista de psicólogos  
**Então** o sistema deverá retornar os psicólogos cadastrados e suas informações profissionais.

### CA-006 — Visualização de psicólogo

**Dado** que exista um psicólogo cadastrado  
**Quando** o usuário solicitar suas informações  
**Então** o sistema deverá apresentar os dados profissionais disponíveis, incluindo o CRP.

### CA-007 — Consulta de disponibilidade

**Dado** que o usuário tenha selecionado um psicólogo  
**Quando** solicitar seus horários disponíveis  
**Então** o sistema deverá apresentar as datas e horários disponíveis para agendamento.

### CA-008 — Agendamento de consulta

**Dado** que exista um horário disponível para determinado psicólogo  
**Quando** o usuário selecionar a data e o horário e confirmar o agendamento  
**Então** o sistema deverá registrar a consulta e atribuir o status **AGENDADA**.

### CA-009 — Agendamento em horário indisponível

**Dado** que determinado horário esteja ocupado ou indisponível  
**Quando** o usuário tentar realizar um agendamento nesse horário  
**Então** o sistema deverá rejeitar a operação e informar que o horário não está disponível.

### CA-010 — Consulta das consultas do usuário

**Dado** que o usuário possua consultas registradas  
**Quando** solicitar suas consultas  
**Então** o sistema deverá apresentar as consultas vinculadas ao usuário, incluindo data, horário, psicólogo e status.

### CA-011 — Acesso ao atendimento online

**Dado** que uma consulta possua um link de atendimento  
**Quando** o usuário autorizado acessar os dados da consulta  
**Então** o sistema deverá disponibilizar o link correspondente.

### CA-012 — CRP duplicado

**Dado** que já exista um psicólogo cadastrado com determinado CRP  
**Quando** um usuário autorizado tentar cadastrar outro psicólogo com o mesmo CRP  
**Então** o sistema deverá rejeitar o cadastro.

### CA-013 — Acesso administrativo

**Dado** que o usuário possua perfil administrativo  
**Quando** acessar uma funcionalidade exclusiva de administração  
**Então** o sistema deverá permitir o acesso conforme suas permissões.

### CA-014 — Acesso não autorizado

**Dado** que o usuário esteja autenticado, mas não possua a permissão necessária  
**Quando** tentar acessar uma funcionalidade restrita  
**Então** o sistema deverá negar o acesso.

### CA-015 — Validação de dados

**Dado** que o usuário esteja realizando uma operação de cadastro ou agendamento  
**Quando** enviar dados obrigatórios inválidos ou incompletos  
**Então** o sistema deverá rejeitar a operação e informar os dados que precisam ser corrigidos.

### CA-016 — Persistência da consulta

**Dado** que uma consulta tenha sido agendada com sucesso  
**Quando** o sistema concluir o processamento  
**Então** os dados da consulta deverão ser armazenados no banco de dados e permanecer disponíveis para consulta.

## 8. Qualidade, riscos e decisões
**Requisitos de qualidade:** 
- Interface utilizável através de teclado e mouse
- Manter fontes visíveis nas buscas auxiliares da IA
- O sistema deve estar em conformidade com a LGPD
- O sistema deverá utilizar controle de acesso baseado em papéis (roles), garantindo que cada usuário possa executar apenas as operações permitidas para seu perfil
- O sistema deverá armazenar as senhas dos usuários de forma segura, utilizando algoritmo de hash apropriado, não permitindo o armazenamento de senhas em texto puro
- O sistema deverá retornar respostas padronizadas e adequadas para situações de erro, evitando a exposição de informações internas da aplicação
- A API deverá possuir documentação das principais operações, endpoints, parâmetros, respostas e requisitos de autenticação, facilitando sua utilização e manutenção
- O código-fonte e as alterações estruturais do sistema deverão ser controlados por versionamento, permitindo acompanhar alterações e recuperar versões anteriores quando necessário
- O sistema deverá utilizar migrações versionadas para controlar a evolução do banco de dados, permitindo que a estrutura necessária seja reproduzida de forma consistente em diferentes ambientes

**Riscos principais:** [Uma busca com filtragem indicar uma resposta plausível mas que fuja de algum dos filtros, levando o paciente a agendar uma consulta com um psicólogo que não se adequa as necessidades dele, um paciente agendar uma consulta mas o sistema falhar nesse agendamento e ainda assim mostrar um resultado de sucesso no agendamento]  
**Mitigações:** [Escopo restrito, resposta baseadas unicamente em fontes, a consulta só mudará o status do agendamento caso o paciente confirme de certeza, a busca só retornará resultados após validar os filtros]  
**Questões para o PO:** [Caso haja conflito nos arquivos que informam os psicólogos/clinicas psicológicas cadastradas no sistema, qual arquivo deve prevalecer como oficial? Caso ocorra de o paciente confirmar um agendamento e o sistema não registrar esse agendamento, como devemos prosseguir com esse paciente?]  
**Decisões confirmadas:** [decisão, data e responsável //Não entendi o que seria para colocar aqui, verifiquei o arquivo de exemplo mas essa opção não aparece nele.]

**Testes relacionados:** [T-001 a T-016 correspondem aos critérios CA-001 a CA-016.]
