# MrBet — Projeto de Casa de Apostas (Experimental)

**MrBet** é um projeto em **Java** que simula uma casa de apostas esportivas fictícia. O sistema foi desenvolvido como um exercício acadêmico, com foco em organização de código e estudo de conceitos de programação orientada a objetos. Este projeto não é voltado para uso prático.

## Estrutura do Sistema

O projeto é composto por cinco classes principais, cada uma com responsabilidades bem definidas:

- **MrBetMain**  
  É o ponto de entrada do sistema e fornece a interface de usuário em linha de comando (CLI). Permite que o usuário navegue por menus para adicionar times, criar campeonatos, incluir times em campeonatos, realizar apostas e consultar o status das apostas. Toda a interação é intermediada pelo `MrBetController`.

- **MrBetController**  
  Centraliza a lógica de negócio do sistema. Controla os times, campeonatos e apostas, garantindo consistência e regras de validação (como limites de participantes e prevenção de duplicatas). Também coordena operações de cadastro de times, campeonatos, inclusão de times em campeonatos e registro de apostas.

- **Campeonato**  
  Representa um campeonato esportivo. Armazena seu nome, limite de participantes e os times inscritos. Fornece métodos para adicionar times, verificar limites e listar participantes.

- **Time**  
  Representa um time esportivo. Contém informações como id, nome, mascote e a lista de campeonatos em que participa. Possui métodos para adicionar campeonatos e exibir suas participações de forma formatada.

- **Aposta**  
  Representa uma aposta feita pelo usuário. Contém dados como o time apostado, campeonato, colocação e valor da aposta. Possui método `toString()` para exibir a aposta de forma clara e formatada.

## Tecnologias e Conceitos

- Linguagem: **Java**
- Estrutura orientada a objetos, com separação de responsabilidades  
- Padrões usados:
  - **Fachada / Controller** (`MrBetController` serve como controlador central)  
  - Interface de usuário via **CLI** (`MrBetMain`)  
- Coleções utilizadas: `HashMap`, `ArrayList`  

