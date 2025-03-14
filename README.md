# CaixaController

<<<<<<< HEAD
CaixaController é um projeto Spring Boot para gerenciar entradas financeiras. Ele fornece uma API RESTful para criar, buscar, atualizar e excluir entradas financeiras, além de buscar entradas por data e tipo.
=======
## Diagrama de Classes Inicial
>>>>>>> 3d9ffa3247a24cd1177308882534a1a078a76219

## Funcionalidades

- Criar uma nova entrada financeira
- Buscar uma entrada financeira por ID
- Atualizar uma entrada financeira existente
- Excluir uma entrada financeira
- Buscar todas as entradas financeiras
- Buscar entradas financeiras por data
- Buscar entradas financeiras por tipo

## Endpoints

- `POST /entry/post`: Cria uma nova entrada financeira
- `GET /entry/get/{id}`: Busca uma entrada financeira por ID
- `PUT /entry/put/{id}`: Atualiza uma entrada financeira existente
- `DELETE /entry/delete/{id}`: Exclui uma entrada financeira
- `GET /entry`: Busca todas as entradas financeiras
- `GET /entry/getByDate/{date}`: Busca entradas financeiras por data
- `GET /entry/getByType/{type}`: Busca entradas financeiras por tipo

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (ou outro banco de dados de sua escolha)
- Maven

## Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/caixacontroller.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd caixacontroller
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em `http://localhost:8080/entry`.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
