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

**Entradas:** [dados fornecidos pelo usuário ou por sistemas]  
**Saídas:** [resultado observável]  
**Precondições:** [estado necessário]

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
