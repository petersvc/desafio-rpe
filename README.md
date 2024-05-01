# Desafio RPE

Este é um projeto desenvolvido como parte do processo seletivo da RPE, para a vaga de estagiário backend. É uma aplicação para gerenciamento de veículos, com funcionalidades para cadastrar, listar, atualizar e excluir veículos de carga e de passeio.
O desafio em si pode ser encontrado em: [desafio-rpe](https://github.com/FabricioLiber/desafio-estagiario-3).

Foi implementado todos os pré-requisitos obrigatórios e extras:
* Utilização de banco de dados Oracle, MySQL, H2, Postgres ou qualquer outro banco relacional.
* Java 17+.
* Maven.
* Spring.
   * Spring Boot.
   * Spring Data JPA.
   * Spring Web.
* Swagger.
* Endpoints.
* Testes unitários.
* Docker.
* Spring Security.
* Deploy em uma plataforma Cloud (Render).

## Tecnologias Utilizadas

- Java
- Spring Boot
- PostgreSQL
- Docker
- Maven
- H2 Database (para testes)
- Swagger (para documentação da API)

## Estrutura do Projeto

A estrutura do projeto segue os padrões do Spring Boot:

- **entities**: Contém as entidades JPA para os veículos de carga e de passeio.
- **dtos**: Define os DTOs (Data Transfer Objects) utilizados nas operações da API.
- **repositories**: Repositórios JPA para acesso aos dados.
- **services**: Lógica de negócio e manipulação dos dados.
- **controllers**: Controladores REST para exposição da API.
- **exceptions**: Exceções personalizadas.
- **infra**: Configuração da aplicação.
- **test**: Testes automatizados.

## Utilizando a API via browser
**É possível utilizar a api, ao menos parcialmente, via swagger-ui, acessível em: **[API](https://desafio-rpe.onrender.com/swagger-ui/index.html)**.**
Verifique a seção `Como usar a API` para mais informações.

## Configuração do Ambiente de Execução

### Docker
Para executar a aplicação em um ambiente Docker, siga os passos abaixo:

1. Certifique-se de ter as seguintes dependências instaladas em sua máquina:
    - Docker
    - docker-compose.
2. Clone o repositório para sua máquina local.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando `docker-compose up` ou `docker compose up`  para iniciar os containers do PostgreSQL e da aplicação.
5. Acesse a documentação da API em `http://localhost:54321/swagger-ui/index.html`.

### Sem Docker (Local)
Para executar a aplicação sem Docker, siga os passos abaixo:

1. Certifique-se de ter as seguintes dependências instaladas em sua máquina:
    - Java 21.
    - Maven.
    - PostgreSQL.
2. Clone o repositório para sua máquina local.
3. Navegue até o diretório raiz do projeto.
4. Certifique-se de substituir os valores das variáveis de ambiente citadas abaixo nos comandos, são elas:
    - `DATABASE_URL`: URL de conexão com o banco de dados.
    - `DATABASE_USERNAME`: Usuário do banco de dados.
    - `DATABASE_PASSWORD`: Senha do banco de dados
5. Para executar a aplicação, você pode escolher entre as seguintes opções:
    - Em modo de desenvolvimento:
      - Comando:`DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres mvn spring-boot:run` 
    - Executando uma build já compilada:
      - Para compilar o projeto execute:`DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres mvn clean package -DskipTests`.
      - Para iniciar a aplicação execute:`DATABASE_URL=jdbc:postgresql://localhost:5432/rpe DATABASE_USERNAME=postgres DATABASE_PASSWORD=postgres java -jar ./target/*.jar`.
6. Acesse a documentação da API em `http://localhost:8080/swagger-ui/index.html`.

Alternativamente, caso não deseje utilizar variáveis de ambiente,
você pode modificar diretamente no arquivo `application.properties`, os valores das seguintes propriedades:
- `spring.datasource.url`: URL de conexão com o banco de dados.
- `spring.datasource.username`: Usuário do banco de dados.
- `spring.datasource.password`: Senha do banco de dados.

E então executar a aplicação sem definir as variáveis de ambiente no momento da execução,
bastanto apenas executar o comando `mvn spring-boot:run` ou após
executar o comando `mvn clean package -DskipTests`, executar `java -jar ./target/*.jar`.

## Como usar a API
É possível utilizar a API através de um programa como o Postman ou Insomnia.

Os endpoints disponíveis estão listados na documentação da API, acessível em `http://localhost:54321/swagger-ui/index.html`, `http://localhost:8080/swagger-ui/index.html` ou ainda
`https://desafio-rpe.onrender.com/swagger-ui/index.html`. 

É possível observar os detalhes de cada endpoint, como os parâmetros necessários através do swagger-ui.

É preciso levar em consideração que o spring security está habilitado, então é necessário autenticar-se para acessar os endpoints.

Apenas o endereço do swagger-ui está disponível sem autenticação.
Para autenticar-se e obter o token JWT, é necessário enviar uma requisição POST para o endpoint `/auth` com o seguinte corpo, por exemplo:
```json
{
  "login": "peter2",
  "senha": "12345",
  "perfil": "USUARIO"
}
```
Existem dois perfis disponíveis: `ADMIN` e `USUARIO`.

`ADMIN` tem permissão para acessar todos os endpoints. 

Enquanto `USUARIO` tem permissão apenas para acessar os endpoints de listagem e busca.

O token JWT retornado deve ser utilizado no cabeçalho `Authorization` das requisições para os demais endpoints, no formato `Bearer`.