# SPRING CLOUD E DEPLOY COM DOCKER

----

## Objetivo:

A finalidade do projeto é criar vários microserviços que vão se comunicar em um rede e focando em realizar implantar em diversos ambientes como: desenvolvimento, testes e produção.
Utilizando conceito de servidor de configurações para armazenar aas configurações dos microserviços principais.
O contexto utilizado foi uma folha de pagamento calculando o valor a receber em dias dos trabalhores.
Com isso, aprimorando conhecimento com os conceitos usados e praticados.
Quaiquer dúvidas, estou a dispoição.

---
## Descrição técnicas:
### dependëncias e ferramentas utilizadas:
  * Linguagem java na versão 11
  * Spring boot (versão 2.3.4.RELEASE e 2.5.3 e 2.5.4)
  * Spring boot Web
  * Spring boot actuator
  * Spring boot JPA
  * Postgresql Driver (versão runtime)
  * Spring Cloud ( versão 2020.03 e oxton.SR8)
  * Spring Cloud Config Server
  * Spring cloud eureka client
  * Spring cloud eureka Server
  * Spring Cloud oauth2
  * Spring Cloud openfeign
  * Spring Cloud resilience4j
  * Maven
  * database H2
  * Banco de dados Postgresql 12
  * Docker
  * bash scripts
  * GitLab

### Microserviços:
- hr-api-gateway-zuul: responsável por ligar todos eles em uma única URL;
- hr-config-server: responsável por gerenciar as configuracões de properties do spring para demais microservicos que são clientes dele;
- hr-eureka-server: responsável por registrar os microservicos clientes para facilitar a comunicacao entre microservicos;
- hr-oauth: responsável por fazer gerenciamento de autenticacao de usuario e aplicacao;
- hr-payroll: responsável por calcular o valor e horas de um trabalhador;
- hr-user: responsável por persistir os usuarios/login;
- hr-worker: reponsável por persistir dados dos trabalhadores.

### Scripts em bash
