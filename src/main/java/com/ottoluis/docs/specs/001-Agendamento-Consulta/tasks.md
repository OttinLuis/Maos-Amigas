Tarefas da funcionalidade — Mãos Amigas

Entrada: spec.md, plan.md e artefatos de apoio revisados.

Objetivo: implementar o cadastro de disponibilidade dos psicólogos, a consulta de horários livres, a integração da IA com dados reais e o agendamento de consultas online.

Formato: [ID] [P?] [US?] ação com caminho exato e resultado verificável.

* [P] indica tarefas que podem ser executadas em paralelo.
* [US] identifica a história de usuário relacionada.
* Marcar [x] somente quando a implementação e sua verificação estiverem concluídas.

Fase 1 — Preparação

* [ ]	T001 Criar a estrutura de pacotes para disponibilidade em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/, seguindo a organização existente no projeto.
* [ ]	T002 [P] Revisar os requisitos e critérios de aceitação em src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/spec.md.
* [ ]	T003 [P] Atualizar o plano de implementação em src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/plan.md, incluindo disponibilidade, IA e agendamento online.
* [ ]	T004 [P] Criar ou revisar a documentação de configuração em src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/quickstart.md.

Fase 2 — Base compartilhada

* [ ]	T005 Criar a entidade de disponibilidade em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/Disponibilidade.java, representando psicólogo, dia da semana, horário inicial e horário final.
* [ ]	T006 [P] Criar o repositório em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeRepository.java, permitindo consultar as disponibilidades por psicólogo e dia da semana.
* [ ]	T007 [P] Criar DTOs de cadastro, atualização e consulta em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DTO/, validando os dados de entrada.
* [ ]	T008 Implementar validações de horários em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeService.java, rejeitando intervalos inválidos.
* [ ]	T009 [P] Criar testes das regras de disponibilidade em src/test/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeServiceTest.java.
* [ ]	T010 Revisar a integração entre disponibilidade, psicólogos e consultas nos pacotes src/main/java/com/ottoluis/MaosAmigas/SuportePsicologico/ e src/main/java/com/ottoluis/MaosAmigas/Consulta/.

Fase 3 — História de usuário 1: Cadastro de disponibilidade

Objetivo: permitir que cada psicólogo cadastre e gerencie os dias e horários em que atende.

Teste independente: cadastrar a disponibilidade de um psicólogo, consultar os dados persistidos e verificar que outro psicólogo não consegue alterá-los sem autorização.

* [ ]	T011 [P] [US1] Criar testes dos endpoints em src/test/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeControllerTest.java, cobrindo cadastro, consulta, atualização, exclusão e autorização.
* [ ]	T012 [US1] Implementar o serviço de cadastro, consulta, atualização e exclusão em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeService.java.
* [ ]	T013 [US1] Implementar os endpoints REST em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeController.java, respeitando a autenticação JWT e as permissões do usuário.
* [ ]	T014 [US1] Integrar a disponibilidade às entidades e aos repositórios de psicólogos em src/main/java/com/ottoluis/MaosAmigas/SuportePsicologico/.
* [ ]	T015 [US1] Criar a tela de gerenciamento da disponibilidade em src/pages/psicologo/Disponibilidade.jsx, com seleção dos dias da semana e dos horários.
* [ ]	T016 [P] [US1] Criar os estilos da tela em src/pages/psicologo/Disponibilidade.css, contemplando estados de carregamento, sucesso e erro.
* [ ]	T017 [US1] Integrar a tela aos endpoints em src/services/api.js, permitindo salvar e consultar as disponibilidades do psicólogo autenticado.
* [ ]	T018 [US1] Executar os testes da US1 e registrar os resultados verificados em src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/quickstart.md.

Fase 4 — História de usuário 2: Consultar horários livres pela IA

Objetivo: fazer a IA oferecer somente horários realmente disponíveis, com duração de 50 minutos, considerando as consultas existentes.

Teste independente: cadastrar uma disponibilidade, criar uma consulta ocupando parte do expediente e verificar que a IA não sugere o horário ocupado.

* [ ]	T019 [P] [US2] Criar testes de geração de horários em src/test/java/com/ottoluis/MaosAmigas/Disponibilidade/HorariosDisponiveisServiceTest.java.
* [ ]	T020 [US2] Implementar a geração de horários livres em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/HorariosDisponiveisService.java, respeitando expediente, duração de 50 minutos e consultas existentes.
* [ ]	T021 [US2] Implementar consultas aos intervalos ocupados em src/main/java/com/ottoluis/MaosAmigas/Consulta/ConsultaRepository.java.
* [ ]	T022 [US2] Criar ou integrar o endpoint de horários disponíveis em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/DisponibilidadeController.java, filtrando por psicólogo e data.
* [ ]	T023 [US2] Integrar a recuperação de horários ao serviço da IA em src/main/java/com/ottoluis/MaosAmigas/Ia/IaService.java.
* [ ]	T024 [US2] Integrar o contexto operacional ao cliente Groq em src/main/java/com/ottoluis/MaosAmigas/Ia/GroqClient.java, garantindo que o modelo utilize horários retornados pelo backend.
* [ ]	T025 [US2] Criar testes de integração em src/test/java/com/ottoluis/MaosAmigas/Ia/IaServiceTest.java, verificando que a IA não inventa horários.
* [ ]	T026 [US2] Verificar a identificação do usuário autenticado no fluxo da IA em src/main/java/com/ottoluis/MaosAmigas/Ia/, protegendo os dados pessoais.
* [ ]	T027 [US2] Executar testes do endpoint POST /ia/chat e registrar os resultados em src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/quickstart.md.

Fase 5 — História de usuário 3: Agendar consultas com segurança

Objetivo: permitir que o usuário confirme uma consulta sem conflitos de horário e com persistência no banco de dados.

Teste independente: agendar um horário livre e tentar agendar novamente o mesmo intervalo. A primeira operação deve ser concluída e a segunda recusada.

* [ ]	T028 [P] [US3] Criar testes de agendamento em src/test/java/com/ottoluis/MaosAmigas/Consulta/ConsultaServiceTest.java.
* [ ]	T029 [US3] Implementar a validação da disponibilidade antes de salvar uma consulta em src/main/java/com/ottoluis/MaosAmigas/Consulta/ConsultaService.java.
* [ ]	T030 [US3] Implementar prevenção de reservas simultâneas conflitantes em src/main/java/com/ottoluis/MaosAmigas/Consulta/ConsultaService.java, utilizando uma estratégia transacional adequada.
* [ ]	T031 [US3] Integrar a confirmação do agendamento pela IA em src/main/java/com/ottoluis/MaosAmigas/Ia/IaService.java, validando a disponibilidade antes da persistência.
* [ ]	T032 [US3] Criar testes de integração do fluxo de consultas em src/test/java/com/ottoluis/MaosAmigas/Consulta/ConsultaControllerTest.java, cobrindo autenticação, dados inválidos e conflitos.
* [ ]	T033 [US3] Integrar a apresentação das consultas ao frontend em src/pages/consulta/, respeitando os componentes e as rotas existentes.

Fase 6 — História de usuário 4: Encontrar profissionais disponíveis e agendar consulta online

História de usuário: Como usuário que busca atendimento psicológico, quero encontrar profissionais disponíveis e agendar uma consulta online, para conseguir acesso ao atendimento psicológico de forma simples e organizada.

Prioridade: P1

Teste independente: o usuário consegue consultar os profissionais disponíveis e concluir o agendamento de uma consulta de forma independente, mesmo que funcionalidades complementares do sistema ainda não estejam implementadas.

* [ ]	T034 [P] [US4] Criar testes de integração para consulta de profissionais em src/test/java/com/ottoluis/MaosAmigas/SuportePsicologico/SuportePsicologicoControllerTest.java, verificando resultados, disponibilidade e ausência de profissionais elegíveis.
* [ ]	T035 [P] [US4] Criar testes do fluxo de agendamento em src/test/java/com/ottoluis/MaosAmigas/Consulta/ConsultaControllerTest.java, cobrindo agendamento válido, horário ocupado, dados inválidos e usuário não autenticado.
* [ ]	T036 [US4] Implementar ou revisar a consulta de profissionais em src/main/java/com/ottoluis/MaosAmigas/SuportePsicologico/, permitindo listar os psicólogos cadastrados e identificar os elegíveis conforme a disponibilidade.
* [ ]	T037 [US4] Implementar ou revisar a consulta de horários livres em src/main/java/com/ottoluis/MaosAmigas/Disponibilidade/, considerando dias de atendimento, horários cadastrados e consultas existentes.
* [ ]	T038 [US4] Implementar ou revisar a validação e persistência do agendamento em src/main/java/com/ottoluis/MaosAmigas/Consulta/ConsultaService.java, impedindo horários inválidos ou conflitantes.
* [ ]	T039 [US4] Integrar o fluxo de agendamento ao endpoint em src/main/java/com/ottoluis/MaosAmigas/Consulta/ConsultaController.java, associando a consulta ao usuário autenticado e ao psicólogo selecionado.
* [ ]	T040 [US4] Criar a tela de busca de psicólogos em src/pages/consulta/BuscarPsicologos.jsx, apresentando os profissionais disponíveis e permitindo selecionar um profissional.
* [ ]	T041 [P] [US4] Criar os estilos da busca de psicólogos em src/pages/consulta/BuscarPsicologos.css, contemplando responsividade, carregamento, erros e ausência de resultados.
* [ ]	T042 [US4] Criar a interface de seleção de data e horário em src/pages/consulta/AgendarConsulta.jsx, exibindo apenas os horários retornados pelo backend como disponíveis.
* [ ]	T043 [US4] Integrar as telas de busca e agendamento à API em src/services/api.js, permitindo consultar profissionais, recuperar horários livres e enviar a solicitação de agendamento.
* [ ]	T044 [US4] Implementar a confirmação do agendamento em src/pages/consulta/AgendarConsulta.jsx, apresentando profissional, data, horário e situação após a confirmação do backend.
* [ ]	T045 [US4] Criar testes da jornada completa em src/, verificando busca do psicólogo, seleção do horário, conclusão do agendamento e visualização da confirmação.
* [ ]	T046 [US4] Integrar a jornada à triagem e à IA em src/main/java/com/ottoluis/MaosAmigas/Ia/IaService.java, permitindo encaminhar o usuário ao agendamento sem deixar o modelo inventar horários ou confirmar consultas sem persistência.
* [ ]	T047 [US4] Executar o teste independente da US4 e registrar os resultados verificados em docs/ia/triage-final.md, incluindo busca de profissionais, seleção de horário, persistência e prevenção de conflitos.

Fase 7 — Qualidade transversal e entrega

* [ ]	T048 Executar os testes relacionados aos critérios de aceitação das quatro histórias de usuário.
* [ ]	T049 Revisar logs, segredos, acessibilidade, mensagens de erro, autenticação JWT e proteção dos dados pessoais em src/main/java/com/ottoluis/MaosAmigas/.
* [ ]	T050 Verificar que chaves do Groq, chaves privadas JWT, senhas e demais segredos não estão versionados no repositório Git.
* [ ]	T051 Atualizar src/main/java/com/ottoluis/docs/specs/001-Agendamento-Consulta/quickstart.md com os comandos, endpoints e procedimentos realmente verificados.
* [ ]	T052 Conferir a rastreabilidade entre os requisitos de spec.md, as decisões de plan.md, os testes e as tarefas.
* [ ]	T053 Executar ./mvnw test na raiz do backend e corrigir falhas.
* [ ]	T054 Executar ./mvnw verify na raiz do backend e verificar compilação e testes de integração.
* [ ]	T055 Executar a compilação e os testes disponíveis do frontend em ~/Maos-Amigas-Front/, utilizando os scripts definidos em package.json.
* [ ]	T056 Executar uma demonstração ponta a ponta: cadastrar disponibilidade, encontrar um psicólogo, consultar horários, agendar uma consulta, confirmar a persistência e verificar que o horário deixa de aparecer como livre.

Dependências

* T001 a T010 estabelecem a preparação e a base compartilhada.
* T011 a T018 implementam e verificam o cadastro de disponibilidade.
* T020 a T027 dependem das regras e dos dados de disponibilidade e das consultas.
* T029 a T032 implementam e verificam a prevenção de conflitos.
* US1 pode ser demonstrada antes das demais histórias.
* US2 pode ser testada com dados fictícios antes da integração completa da IA.
* US3 depende da validação de disponibilidade e da persistência segura das consultas.
* US4 depende dos serviços de profissionais, disponibilidade e agendamento, mas seu fluxo principal deve funcionar sem a IA.
* T046 depende de o fluxo independente de agendamento estar funcional.
* T048 a T056 dependem da implementação e integração das histórias anteriores.

Pontos de paralelismo

* T002, T003 e T004 podem avançar em paralelo após a definição dos requisitos.
* Os testes de disponibilidade e os DTOs podem ser desenvolvidos em paralelo após a definição dos contratos.
* T019 e os testes de integração de T020 podem ser preparados em paralelo após a definição do comportamento esperado.
* T034 e T035 podem avançar em paralelo após a definição dos contratos da API.
* T040 e T041 podem avançar em paralelo após a definição do contrato de consulta de profissionais.
* A interface React pode ser desenvolvida em paralelo com os testes de backend depois de definidos os endpoints.
* A revisão de segurança e a documentação podem avançar em paralelo após a estabilização dos fluxos principais.

Critérios de aceitação gerais

* [ ]	Psicólogos conseguem cadastrar e gerenciar suas disponibilidades com autorização.
* [ ]	Os horários livres respeitam os intervalos cadastrados e as consultas existentes.
* [ ]	A IA utiliza dados reais do backend e não inventa disponibilidades.
* [ ]	Consultas não podem ser criadas em horários ocupados ou fora da disponibilidade.
* [ ]	O usuário consegue encontrar profissionais e concluir o agendamento sem depender da IA.
* [ ]	A confirmação de agendamento só é exibida após a persistência bem-sucedida.
* [ ]	O sistema protege a identidade do usuário e os dados pessoais.
* [ ]	Os testes e as demonstrações foram executados e os resultados registrados.

Regra de conclusão: marcar [x] somente quando a tarefa estiver implementada e verificada. Os caminhos propostos devem ser conferidos com a estrutura real do repositório antes da execução.
