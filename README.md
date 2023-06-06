# Docker

1- Iniciar o Docker

# Subir o Banco de Dados

2- Para subir o banco Firebied, abrir um terminal na raiz do projeto
e rodar "sudo docker-compose up"

### Criar sequences

3- Execute o conteudo do script1 em algum client :
Dados para conectar com o banco em um client:
-url conection: jdbc:firebirdsql://localhost:3050/desafio_db
-host: 3050
-login:SYSDBA
-senha: 123456

### Subir applicação MS-DESAFIO

3- Subir a aplicação via IDE, com isso a aplicação criará automaticamente o banco de dados e
suas tabelas.

### Popular base de dados

-Execute o conteudo do script2 em algum client

### Postman

- Importe a collection do postman e a ENV do que se encontra no diretorio postman
- Para chamar qualquer endpoint, precisar chamar o endpoin "login" antes para se autenticar.

### Swagger

http://localhost:8031/swagger-ui/index.html

-Devido a um erro de configuração, que não pude corrigir por conta do prazo, coloque "/v3/api-docs"
no explore do swagger.
