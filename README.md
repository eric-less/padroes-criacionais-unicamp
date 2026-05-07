# Sistema de Relatórios Corporativos — Versão Legado

> Atividade Prática — Padrões Criacionais de Projeto  
> Disciplina: Padrões de Projeto de Software | Instituto de Computação — Unicamp

---

## Sobre o sistema

Este repositório contém o código-fonte de um sistema interno de geração e exportação de relatórios corporativos desenvolvido para uma empresa fictícia. O sistema permite gerar relatórios de vendas, estoque e clientes nos formatos PDF, CSV e JSON, com suporte a configurações globais de ambiente.

O sistema foi desenvolvido ao longo do tempo por diferentes equipes e encontra-se em produção. O código funciona corretamente, atende aos requisitos funcionais e possui cobertura de testes automatizados.

---

## Objetivo da atividade

Esta atividade propõe uma **refatoração arquitetural** do sistema, com foco na aplicação de padrões criacionais de projeto. O sistema atual, embora funcional, apresenta características típicas de código legado que dificultam sua manutenção e evolução.

Vocês deverão analisar o código existente, identificar os aspectos que dificultam a extensibilidade e a manutenção, e propor e implementar uma solução utilizando os padrões **Factory Method** e **Singleton**.

---

## Pré-requisitos

- Java 17 ou superior
- Apache Maven 3.8 ou superior

---

## Como executar

Compilar e empacotar:

```bash
mvn clean package -q
```

Executar o sistema interativo:

```bash
java -jar target/sistema-relatorios.jar
```

Alternativamente, sem gerar o JAR:

```bash
mvn exec:java -Dexec.mainClass="br.unicamp.padroescriacionais.legacy.Main"
```

---

## Como rodar os testes

```bash
mvn test
```

Para exibir o resultado detalhado de cada caso de teste:

```bash
mvn test -Dsurefire.useFile=false
```

---

## Descrição da atividade

### Parte 1 — Refatoração com Factory Method

Analise como o sistema atualmente cria e utiliza os geradores de relatório. Identifique os problemas decorrentes dessa abordagem e refatore o código aplicando o padrão **Factory Method**.

A refatoração deve:

- introduzir uma abstração adequada para os geradores de relatório;
- centralizar a responsabilidade de criação dos geradores em um único ponto;
- eliminar o acoplamento direto dos serviços às classes concretas de geração;
- garantir que a adição de novos formatos não exija alterações nos serviços existentes.

Como extensão obrigatória, implemente suporte aos formatos **XML** e **HTML**, integrando-os à solução refatorada.

### Parte 2 — Refatoração com Singleton

Analise como as configurações globais do sistema são atualmente gerenciadas. Identifique os riscos e inconsistências que a abordagem atual pode introduzir e refatore o código aplicando o padrão **Singleton**.

A refatoração deve:

- garantir que exista apenas uma instância de configuração em toda a aplicação;
- assegurar que todos os componentes do sistema compartilhem a mesma configuração;
- centralizar a definição dos valores de configuração em um único ponto de controle.

### Parte 3 — Testes

- Todos os testes existentes devem continuar passando após a refatoração.
- Novos testes devem ser escritos para cobrir os comportamentos introduzidos pela refatoração, incluindo os novos formatos XML e HTML.

### Parte 4 — Relatório Técnico

Elabore um relatório escrito com no mínimo uma página abordando:

1. Quais características do código legado motivaram a refatoração? Descreva cada problema identificado com suas próprias palavras.
2. Como o padrão Factory Method foi aplicado? Descreva as decisões de modelagem adotadas.
3. Como o padrão Singleton foi aplicado? Quais garantias ele oferece neste contexto?
4. Quais são as vantagens de cada padrão na solução proposta?
5. Quais são as limitações e trade-offs dos padrões utilizados?
6. Em um cenário multi-tenant, onde o sistema precisasse operar simultaneamente em múltiplos ambientes, o Singleton ainda seria a escolha adequada para gerenciar configurações? Justifique.

---

## Regras importantes

- O comportamento funcional do sistema não deve ser alterado.
- O projeto deve compilar sem erros ao final da refatoração.
- Todos os testes existentes devem continuar passando.
- Não é permitido utilizar frameworks externos além dos já declarados no `pom.xml`.

---

## Entregáveis

| Item | Descrição |
|------|-----------|
| Código-fonte | Repositório Git com histórico de commits organizado |
| Diagramas UML | Diagrama de classes da solução refatorada (antes e depois) |
| Relatório técnico | Documento descrevendo a análise e as decisões de design |

O link do repositório deverá ser submetido pelo sistema de entregas da disciplina até a data informada pelo docente.

---

## Critérios de avaliação

| Critério | Peso |
|----------|------|
| Correta aplicação do padrão Factory Method | 25% |
| Correta aplicação do padrão Singleton | 20% |
| Implementação dos novos formatos XML e HTML | 15% |
| Qualidade e cobertura dos testes | 15% |
| Qualidade do relatório técnico e das justificativas | 15% |
| Organização do código e dos commits | 10% |
