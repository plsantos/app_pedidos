<p align="center">
  <img src="https://github.com/plsantos/app_pedidos/blob/develop/src/main/resources/templates/src/assets/img/logo.png" width="800" title="hover text">
</p>
Genius Livraria delivery é uma livraria online que busca facilitar a compra e entrega de livors com o melhor custo-benefício. Nosso catálogo possui os mais diversos gêneros literários para agradar todos os públicos e idades, confira mais!

## Visão Geral
O sistema foi desenvolvido na linguagem de programação Java, utilizando a IDE Intellij e Spring Tool Suite e Java 15. Antes de executar o programa é necessário seguir os passos de instalação abaixo. O projeto possui persistência em  MySQL, que são iniciadas assim que é realizado o primeiro cadastro.

## Modelo entidade relacionamento

<p >
  <img src="https://github.com/plsantos/app_pedidos/blob/develop/bd/MER.png" width="400" title="hover text">
</p>

## Tecnologias utilizadas e Arquitetura 
- REST
- Java
- Spring Boot
- Maven
- H2
- JPA/HIBERNATE
- Postman
- Angular

## Pré requisitos 
- IDE Java (as utilizadas foram IntelliJ IDEA e Spring Tools)
- Angular 
- SGBD criação da base de dados com os seguintes dados:
  -  nome: pedidos
  -  senha: 123456
  -  usuário: root
 
## Como executar o sistema 
### Back-end
- Clone este repositório usando: git clone https://github.com/plsantos/app_pedidos.git
- Importe o projeto na IDE Java de sua preferência 
- Atualize as dependências com o Maven
- Execute o projeto

### Front-end
- Com o back-end rodando vá para o diretório **/app_pedidos/main/resources/templates** e execute os seguintes comandos: 
  - ng serve -o
  - npm install (caso precise instalar dependências)
  - npm install -g @angular/cli (caso precise instalar dependências)
  - ng serve -o
  
## Testes Unitários
Nos testes foi utilizado o JUnit com Mockito e o JPA componentes, os mesmos podem ser encontrados no seguinte diretório **\app_pedidos\src\test\java\com\app_pedidos\tests** 
  
### Autoras :blue_heart:
https://www.linkedin.com/in/paula-libia-santos/

https://www.linkedin.com/in/giovanna-santana-589baa165/

https://www.linkedin.com/in/byanca-calixto-b813a11b7/

https://www.linkedin.com/in/natashabusnardo/

https://www.linkedin.com/in/alline-cardoso/

https://www.linkedin.com/in/caroline-souza-946b0118a/
