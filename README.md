# Desafio Backend PicPay

- Este repositório contém a solução para o desafio backend proposto pela PicPay.

- Link para o Desafio Original: PicPay/picpay-desafio-backend
Sobre o Projeto

- O objetivo deste projeto é implementar uma API RESTful para simular transferências financeiras entre usuários, seguindo as especificações e requisitos do desafio. A aplicação foi desenvolvida com foco em boas práticas de desenvolvimento, arquitetura limpa e segurança.
Tecnologias Utilizadas
  - Java 17: Versão mais recente do Java LTS (Long-Term Support) utilizada no desenvolvimento.
  - Spring Framework 3.4.5: Framework principal para a construção da aplicação, gerenciamento de dependências e configuração. (Conforme especificado. Para projetos modernos com Java 17, é mais comum o uso de versões mais recentes do Spring Boot, como Spring Boot 3.x).

### Arquitetura

- O projeto adota os princípios da Clean Architecture. Essa abordagem visa criar um sistema desacoplado, testável e de fácil manutenção, separando as responsabilidades em camadas distintas:

  - **Domain**: Contém as regras de negócio centrais e entidades da aplicação. É a camada mais interna e independente.

  - **Application:** Orquestra os casos de uso da aplicação, utilizando as entidades e regras de negócio do domínio.

  - **Infrastructure:** Lida com detalhes de implementação, como acesso a banco de dados, frameworks web, e serviços externos.

- Essa separação garante que a lógica de negócio permaneça isolada de preocupações de infraestrutura, facilitando a evolução e a testabilidade do sistema.
Segurança

### A segurança é um aspecto crucial desta aplicação. Foram implementados mecanismos de:
  - Autenticação: Processo para verificar a identidade dos usuários que tentam acessar o sistema. Garante que apenas usuários legítimos possam interagir com a API.
  - Autorização: Após a autenticação, a autorização define quais recursos e operações um usuário autenticado tem permissão para acessar. Isso assegura que os usuários só possam realizar ações para as quais têm privilégios.

### Tratamento de Exceções

- Para um melhor controle e feedback sobre erros na aplicação, foi implementado um sistema de Custom Exceptions (Exceções Personalizadas). Isso permite:
   - Capturar e tratar erros de forma específica para diferentes cenários de negócio.
   - Fornecer mensagens de erro claras e informativas para os usuários da API.
   - Facilitar o debugging e a monitoria da aplicação.

- Cada exceção personalizada carrega informações relevantes sobre o erro ocorrido, ajudando a identificar a causa raiz e a tomar as ações corretivas necessárias.

*Este README fornece uma visão geral do projeto, suas tecnologias e as principais decisões arquiteturais e de design. Para mais detalhes, consulte o código-fonte e a documentação específica de cada módulo.*
