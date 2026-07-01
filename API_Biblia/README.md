# 📖 API Bíblia


API REST desenvolvida em **Java + Spring Boot** para disponibilizar informações bíblicas por meio de endpoints protegidos por autenticação JWT, acompanhada de uma interface web para documentação e utilização da API.


---


# Integrantes

## Gabriel Martins


Responsável pelo desenvolvimento do **Back-end**.


### Funcionalidades desenvolvidas


- Modelagem do banco de dados PostgreSQL
- Desenvolvimento da API REST utilizando Spring Boot
- Criação das entidades e relacionamentos
- Implementação da camada de persistência (Repositories)
- Implementação da camada de serviços (Services)
- Desenvolvimento dos Controllers
- Sistema de cadastro de usuários
- Sistema de login
- Geração de API Key para cada usuário
- Implementação de autenticação utilizando JWT
- Configuração do Spring Security
- Desenvolvimento do endpoint do Dashboard
- Configuração do Swagger/OpenAPI
- Configuração do Docker e Docker Compose
- Inicialização automática do banco de dados
- Organização da arquitetura do projeto


---


## Lana Cristina Da Silva Bastos


Responsável pelo desenvolvimento do **Front-end**.


### Funcionalidades desenvolvidas


- Desenvolvimento da interface web
- Tela de Login
- Tela de Cadastro
- Tela de Documentação
- Organização dos arquivos HTML
- Desenvolvimento dos arquivos CSS
- Desenvolvimento dos scripts JavaScript
- Integração entre Front-end e API
- Exibição dos exemplos de requisição e resposta
- Organização visual da documentação


---


# Tecnologias utilizadas


## Back-end


- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- PostgreSQL
- Swagger / OpenAPI
- Maven
- Docker


## Front-end


- HTML5
- CSS3
- JavaScript


---


# Arquitetura do projeto


![Fluxo da Arquitetura do Sistema](/API_Biblia/src/main/resources/static/img/fluxo-arquitetura.png)


A aplicação segue uma arquitetura em camadas, separando responsabilidades entre apresentação, regras de negócio e acesso ao banco de dados.


---


# Fluxo do Back-end


O funcionamento da API segue o seguinte fluxo:


![Fluxo de dados de Arquitetura Backend](/API_Biblia/src/main/resources/static/img/fluxo-backend.png)


## Controller


Responsável por receber as requisições HTTP e devolver as respostas ao cliente.


Não contém regras de negócio.


---


## Service


Responsável por toda a lógica da aplicação.


Exemplos:


- Cadastro de usuários
- Login
- Geração do JWT
- Validação de Token
- Regras dos endpoints


---


## Repository


Responsável pela comunicação com o banco de dados através do Spring Data JPA.


---


## Banco de Dados


O PostgreSQL armazena:


- Usuários
- API Keys
- Livros
- Capítulos
- Versículos
- Temas


---


# Fluxo do Front-end


![Fluxo de dados de Arquitetura frontend](/API_Biblia/src/main/resources/static/img/fluxo-frontend.png)


Todo o consumo da API é realizado utilizando **Fetch API**, enviando e recebendo dados em formato JSON.


---

# Fluxo de autenticação


## Cadastro
![Fluxo de dados de Autenticação de cadastro](/API_Biblia/src/main/resources/static/img/fluxo-autenticação-cadastro.png)


Durante o cadastro são gerados automaticamente:


- API Key
- Senha criptografada com BCrypt
- Data de criação
- Contador inicial de requisições


---


## Login

![Fluxo de dados de Autenticação de login](/API_Biblia/src/main/resources/static/img/fluxo-autenticação-login.png)



Após autenticação bem sucedida é retornado um Token JWT.


Esse token é utilizado em todas as requisições protegidas.


---


## Dashboard


![Fluxo de dados de Autenticação Dashboard](/API_Biblia/src/main/resources/static/img/fluxo-autenticação-dashboard.png)


O Dashboard retorna:


- Nome do usuário
- API Key
- Quantidade de requisições


---


# Estrutura do projeto


```
src
 └── main
 ├── java
 │
 │ ├── config
 │ ├── controller
 │ ├── dto
 │ ├── entity
 │ ├── repository
 │ └── services
 │
 └── resources
 ├── static
 │ ├── css
 │ ├── js
 │ ├── images
 │ ├── login.html
 │ ├── cadastro.html
 │ └── docs.html
 │
 ├── application.properties
 ├── application-docker.properties
 └── application-local.properties
```


---


# Endpoints


## Cadastro


```
POST /cadastro
```


Cria um novo usuário.


### Body


```json
{
 "nome": "String",
 "email": "String",
 "senha": "String"
}
```


---


## Login


```
POST /login
```


Realiza autenticação.


### Body


```json
{
 "email": "String",
 "senha": "String"
}
```


### Resposta


```json
{
 "token":"String"
}
```


---


## Dashboard


```
GET /developer/dashboard
```


Necessita autenticação.


Retorna:


```json
{
 "nome":"String",
 "apiKey":"String",
 "requisicoes": long
}
```


---


## Demais endpoints


A API também disponibiliza endpoints para consulta de:

- GET/Temas
- GET/Temas/unitarismo
- GET/Versículos/Aleatórios


Todos protegidos por autenticação JWT.


---


# Segurança


A API utiliza:


- BCrypt para criptografia das senhas
- JWT para autenticação
- Spring Security para proteção dos endpoints
- API Key individual para cada usuário


---


# Banco de Dados


Durante a inicialização são criadas automaticamente as tabelas necessárias.


O arquivo


```
database/init.sql
```


é responsável pela inserção dos dados iniciais da aplicação.


Exemplo:


- Bíblia
- Livros
- Capítulos
- Versículos
- Temas


---


# Executando com Docker


## Clonar o projeto


```bash
git clone <URL_DO_REPOSITORIO>
```


---


## Entrar na pasta


```bash
cd API_Biblia
```


---

## Gerar .jar

```bash
.\mvnw.cmd clean package -DskipTests
```

## Construir os containers


```bash
docker compose up --build
```


ou


```bash
docker compose up -d --build
```


---


## Serviços iniciados


PostgreSQL


```
localhost:5432
```


API


```
localhost:8080
```


*(ou a porta configurada no projeto)*


---


# Documentação


Após iniciar a aplicação:


Swagger


```
http://localhost:8080/swagger-ui.html
```


---


# Interface Web


Tela de Login


```
http://localhost:8080/login.html
```


Tela de Cadastro


```
http://localhost:8080/cadastro.html
```


Documentação


```
http://localhost:8080/docs.html
```


---


# Considerações finais


Este projeto teve como objetivo aplicar conceitos estudados durante a disciplina de Desenvolvimento Web, envolvendo:


- APIs REST
- Arquitetura em camadas
- Persistência com JPA
- Segurança com JWT
- Docker
- PostgreSQL
- Desenvolvimento Front-end
- Integração entre Front-end e Back-end
- Documentação de APIs


Além da funcionalidade principal da API, o projeto foi desenvolvido buscando organização, escalabilidade e separação de responsabilidades, aproximando sua estrutura da utilizada em aplicações reais.